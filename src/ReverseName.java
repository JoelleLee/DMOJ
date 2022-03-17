import java.io.*;

public class ReverseName {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("Input name: ");
        String name = stdin.readLine();

        String reverse = "";

        int length = name.length();

        for(int i = length - 1; i>= 0; i--){

            reverse = reverse + name.charAt(i);
        }

        System.out.print(reverse);
    }
}
