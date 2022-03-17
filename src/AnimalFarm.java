import java.io.*;

public class AnimalFarm {
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int numPens = Integer.parseInt(stdin.readLine());
        int[][] pens = new int[numPens][8];

        for(int i=0; i<numPens; i++){
            String[] input = stdin.readLine().split(" ");

            for(int j=0; j<Integer.parseInt(input[0]); j++){

            }
        }


    }
}
