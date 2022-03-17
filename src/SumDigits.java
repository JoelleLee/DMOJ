import java.io.*;

public class SumDigits {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("Enter number: ");
        int num = Integer.parseInt(stdin.readLine());
        int sum = 0;

        while(num > 0){

            sum += num%10;

            num = num/10;

        }

        System.out.print(sum);




    }
}
