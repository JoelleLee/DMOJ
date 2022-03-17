import java.io.*;

public class ReverseWord
{
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String[] input = stdin.readLine().split("");

        for(int i=input.length-1; i>=0; i--){
            System.out.print(input[i]);
        }

    }
}
