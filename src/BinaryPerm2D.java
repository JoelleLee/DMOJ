import java.io.*;

public class BinaryPerm2D {
    public static void allPer(int[][] binary, int rowIndex, int colIndex){

        if(rowIndex>=binary.length-1 && colIndex>=binary[0].length){
            for(int i=0; i<binary.length; i++){
                for(int j=0; j<binary[0].length; j++){
                    System.out.print(binary[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
            return;
        }

        if(colIndex>=binary[0].length){
            rowIndex++;
            colIndex=0;
        }

        binary[rowIndex][colIndex]=0;
        allPer(binary, rowIndex, colIndex+1);
        binary[rowIndex][colIndex]=1;
        allPer(binary, rowIndex, colIndex+1);

    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);
        int row=Integer.parseInt(stdin.readLine());
        int col=Integer.parseInt(stdin.readLine());

        int[][] binary = new int[row][col];

        allPer(binary, 0, 0);

    }
}
