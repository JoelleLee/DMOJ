import java.io.*;

public class BinaryPermutations2 {
    public static void allPer(int[] binary, int index){
        if(index>=binary.length){
            for(int i=0; i<binary.length; i++){
                System.out.print(binary[i]);
            }
            System.out.println("");
            return;
        }

        binary[index]=0;
        allPer(binary, index+1);
        binary[index]=1;
        allPer(binary, index+1);
    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);
        int num= Integer.parseInt(stdin.readLine());
        int[] binary = new int[num];
        allPer(binary, 0);

    }
}
