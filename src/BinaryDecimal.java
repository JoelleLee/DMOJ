import java.io.*;

public class BinaryDecimal {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("Input: ");
        int binary = Integer.parseInt(stdin.readLine());

        int decimal = 0;
        int add = 1;

        while(binary > 0){

            decimal += (binary%10)*add;
            binary/= 10;

            add*= 2;
        }

        System.out.print(decimal);

    }
}
