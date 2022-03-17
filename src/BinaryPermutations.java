import java.io.*;

public class BinaryPermutations {
    public static void allPer(String binary, int num){

        if(num==0){
            System.out.println(binary);
            return;
        }
        allPer(binary+"1", num-1);
        allPer(binary+"0", num-1);
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int num = Integer.parseInt(stdin.readLine());
        allPer("", num);
    }
}
