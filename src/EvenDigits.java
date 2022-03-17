import java.io.*;

public class EvenDigits {
    public static int clicks(int N){

        String[] n = (N+"").split("");
        int[] digit = new int[n.length];

        for(int i=0; i<n.length; i++){
            digit[i] = Integer.parseInt(n[i]);
        }

        int i=0;
        int tens = 1;

        for(int j=1; j<digit.length; j++){
            tens*=10;
        }

        while(i<digit.length && digit[i]%2==0){
            i++;
        }

        return 00;
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int T = Integer.parseInt(stdin.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(stdin.readLine());

            //System.out.println("Case #"+i+": "+ clicks(N, (N+"").length(), 0));
        }
    }
}
