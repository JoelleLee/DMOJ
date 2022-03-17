import java.io.*;

public class ModernArt {


    public class Main {
        public static void main(String[] args) throws IOException {
            DataInputStream stdin = new DataInputStream(System.in);

            int rowCnt = Integer.parseInt(stdin.readLine());
            int colCnt = Integer.parseInt(stdin.readLine());
            int K = Integer.parseInt(stdin.readLine());
            int[][] canvas = new int[rowCnt][colCnt];
            //black = 0
            //gold = 1

            for(int k=0; k<K; k++){
                String[] input = stdin.readLine().split(" ");
                int rowCol = Integer.parseInt(input[1])-1;

                if(input[0].equals("R")){
                    for(int x=0; x<canvas[0].length; x++){
                        int value = canvas[rowCol][x];
                        if(value==1){
                            canvas[rowCol][x]--;
                        }
                        else {
                            canvas[rowCol][x]=1;
                        }
                    }
                }
                else{
                    for(int x=0; x<canvas.length; x++){
                        int value = canvas[x][rowCol];
                        if(value==1){
                            canvas[x][rowCol]--;
                        }
                        else {
                            canvas[x][rowCol]=1;
                        }
                    }
                }
            }

            int gold = 0;
            for(int i=0; i<canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {

                }
            }

            System.out.println(gold);
        }
    }

}
