import java.io.*;

public class CountLuck {
    //north0   east1    south2    west3
    public static void direct(int[][] map, int[] rc, int[] directions){

        if(rc[0]-1>=0 && map[rc[0]-1][rc[1]]==0){ //north
            directions[0] = 1;
        }
        else{
            directions[0] = 0;
        }

        if(rc[1]+1<map[0].length && map[rc[0]][rc[1]+1]==0){ //east
            directions[1] = 1;
        }
        else{
            directions[1] = 0;
        }

        if(rc[0]+1<map.length && map[rc[0]+1][rc[1]]==0){ //south
            directions[2] = 1;
        }
        else{
            directions[2] = 0;
        }

        if(rc[1]-1>=0 && map[rc[0]][rc[1]-1]==0){ //west
            directions[3] = 1;
        }
        else{
            directions[3] = 0;
        }
    }
    public static int luck(int[][] map, int[] rc, int[] direct, int turns){

        direct(map, rc, direct);

        if(rc[0]>=map.length || rc[1]>=map[0].length || rc[0]<0 || rc[1]<0 || direct[0]+direct[1]+direct[2]+direct[3]==0){
            return -1;
        }

        if(map[rc[0]][rc[1]]==2){
            return turns;
        }

        for(int i=0; i<4; i++){

        }
        return 0;

    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int testCases = Integer.parseInt(stdin.readLine());

        for(int i=0; i<testCases; i++){
            String[] input = stdin.readLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            int[][] map = new int[row][col];

            int[] rc = new int[2];

            for(int j=0; j<map.length; j++){
                input = stdin.readLine().split(" ");
                for(int k=0; k<map[0].length; k++){
                    //.=0     X=-1      prev=-1   *=2
                    if(input[k].equals("X")){
                        map[j][k] = -1;
                    }
                    else if(input[k].equals("M")){
                        rc[0] = j;
                        rc[1] = k;
                        map[j][k] = 0;
                    }
                    else if(input[k].equals("*")){
                        map[j][k]=2;
                    }
                    else{
                        map[j][k] = 0;
                    }
                    map[j][k] = Integer.parseInt(input[k]);
                }
            }

            int guess = Integer.parseInt(stdin.readLine());
            boolean[] directions = new boolean[4];

            System.out.println(luck(map, rc, new int[4], 0));

        }

    }
}
