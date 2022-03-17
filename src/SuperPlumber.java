import java.io.*;

public class SuperPlumber {
    static int maxCoins = 0;
    public static void printPath(int[][] map){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j]==-1){
                    System.out.print("*");
                }
                else if(map[i][j]==0){
                    System.out.print(".");
                }
                else if(map[i][j]>0){
                    System.out.print(map[i][j]);
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void numCoins(int[][] map, int total, int r, int c){
        if(r<0 || c<0 || r>=map.length || c>=map[0].length || map[r][c]<0){
            return;
        }

        total+=map[r][c];

        if(r==map.length-1 && c==map[0].length-1){
            printPath(map);

            if(total>maxCoins){
                maxCoins=total;
            }
            return;
        }

        int lastValue = map[r][c];
        map[r][c] = -2;

        numCoins(map, total, r+1, c);
        numCoins(map, total, r, c+1);
        numCoins(map, total, r-1, c);

        map[r][c] = lastValue;
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        String[] input = stdin.readLine().split(" ");

        while(!input[0].equals("0") && !input[1].equals("0")){

            //-1 obstacles
            int[][] map = new int[Integer.parseInt(input[0])][Integer.parseInt(input[1])];

            for(int i=0; i<map.length; i++){
                String mapRow = stdin.readLine();
                for(int j=0; j<map[0].length; j++){
                    if(mapRow.charAt(j)=='.'){
                        map[i][j] = 0;
                    } else if (mapRow.charAt(j) == '*') {
                        map[i][j] = -1;
                    }
                    else {
                        map[i][j] = mapRow.charAt(j)-'0';
                    }
                }
            }
            maxCoins=0;
            numCoins(map, 0, map.length-1, 0);
            System.out.println(maxCoins);
            input = stdin.readLine().split(" ");
        }

    }
}
