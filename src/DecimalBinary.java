import java.io.*;

public class DecimalBinary {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("Input: ");
        int decimal = Integer.parseInt(stdin.readLine());

        int binary = 0;
        int add = 1;

        while(decimal > 0){

            binary += (decimal%2)*add;
            decimal/= 2;


            add*= 10;
        }
        System.out.print(binary);


    }
}
