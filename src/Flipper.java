import java.io.*;

public class Flipper {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int[][] grid = {    {1,2},
                            {3,4}
        };

        String input = stdin.readLine();

        for(int i =0; i<input.length(); i++){
            if(input.charAt(i)=='V'){
                int holder00 = grid[0][0];
                int holder01 = grid[1][0];
                grid[0][0] = grid[0][1];
                grid[1][0] = grid[1][1];
                grid[0][1] = holder00;
                grid[1][1] = holder01;
            }
            else{
                int[] holder = grid[0];
                grid[0] = grid[1];
                grid[1] = holder;
            }

        }

        for(int j=0; j<2; j++){
            System.out.println(grid[j][0] + " " + grid[j][1]);
        }

    }
}
