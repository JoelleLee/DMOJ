import java.io.*;

public class DealnoDeal {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int[] briefcase = {100 , 500, 1000, 5000, 10000, 25000, 50000, 100000, 500000, 1000000};
        int n = Integer.parseInt(stdin.readLine());
        int input;
        int average =0;

        for(int i =0; i<n; i++){
            input = Integer.parseInt(stdin.readLine());
            briefcase[input-1] = 0;
        }

        for(int i = 0; i<10; i++){
            average += briefcase[i];
        }

        input = Integer.parseInt(stdin.readLine());

        if(input > average/(10-n)){
            System.out.println("deal");
        }
        else{
            System.out.println("no deal");
        }

    }
}
