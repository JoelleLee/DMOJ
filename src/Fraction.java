import java.io.*;

public class Fraction {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("numerator: ");
        int n = Integer.parseInt(stdin.readLine());

        System.out.print("denominator: ");
        int d = Integer.parseInt(stdin.readLine());

        int whole = n/d;
        n %= d;

        int i= 2;

        while(i <= n) {
            if(n % i == 0 && d % i == 0){
                    n /= i;
                    d /= i;
            }
            else{
                i++;
            }

        }

        if(whole != 0 || n == 0){
            System.out.print(whole);
        }
        if(n != 0){
            System.out.print(" " + n + "/" + d);
        }

    }
}
