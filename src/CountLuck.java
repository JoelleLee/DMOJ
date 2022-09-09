import java.io.*;

public class CountLuck {
    //north0   east1    south2    west3
    public static int direct(int[][] map, int r, int c){
        int paths = 0;

        if(r-1>=0 && (map[r-1][c]==1 || map[r-1][c]==2)){ //north
            paths++;
        }

        if(c+1<map[0].length && (map[r][c+1]==1|| map[r][c+1]==2)){ //east
            paths++;
        }

        if(r+1<map.length && (map[r+1][c]==1 || map[r+1][c]==2)){ //south
            paths++;
        }

        if(c-1>=0 && (map[r][c-1]==1 || map[r][c-1]==2)){ //west
            paths++;
        }

        return paths;
    }
    public static boolean luck(int[][] map, int guess, int r, int c, int turns){//edit
        if(r<0|| c<0 || r>=map.length || c>=map[0].length || map[r][c]<1 || turns>guess){
            return false;
        }

        if(map[r][c]==2){
            return guess==turns;
        }

        int ways = direct(map, r, c);
        if(ways<=0){
            return false;
        }
        else if(ways>1){
            turns++;
        }

        map[r][c] = -1;

        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if(!(i==0 && j==0) && luck(map, guess,r+i, c+j, turns)){
                    return true;
                }
            }
        }

        map[r][c]=1;

        return false;
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int testCases = Integer.parseInt(stdin.readLine());

        for(int i=0; i<testCases; i++){
            String[] input = stdin.readLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            int[][] map = new int[row][col];

            int rP = 0;
            int cP = 0;

            for(int j=0; j<row; j++){
                input = stdin.readLine().split("");
                for(int k=0; k<col; k++){
                    if(input[k].equals("X")){
                        map[j][k] = -1;
                    }
                    else if(input[k].equals(".")){
                        map[j][k] = 1;
                    }
                    else if(input[k].equals("M")){
                        rP = j;
                        cP = k;
                        map[j][k] = 1;
                    }
                    else if(input[k].equals("*")){
                        map[j][k]=2;
                    }
                }
            }

            int guess = Integer.parseInt(stdin.readLine());

            if(luck(map, guess, rP, cP, 0)){
                System.out.println("Impressed");
            }
            else{
                System.out.println("Oops!");
            }
        }

    }
}


