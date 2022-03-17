import java.io.*;

public class PyramidMessageScheme {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);
        int L = Integer.parseInt(stdin.readLine());
        int C = 0;
        int D = 1;
        String output = "";

        for(int i=0; i<L; i++){

            int n = Integer.parseInt(stdin.readLine());
            String[] message = new String[n];

            message[0]="Home";

            for(int j=1; j<=n; j++){

                String input=stdin.readLine();

                if(C==0 || !input.equals(message[C-1])){
                    C++;
                    message[C]=input;

                    if(D<C){
                        D=C;
                    }
                }
                else{
                    C--;
                }

            }

            int time  = 10*n - 20*(D);
            output += time + "\n";

        }

        System.out.println(output);

    }
}
