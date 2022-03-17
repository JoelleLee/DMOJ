import java.io.*;

public class Substrings {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int N = Integer.parseInt(stdin.readLine());
        String output = "";

        for(int i = 0; i < N; i++){

            String S = stdin.readLine();

            int counter = 1;

            String history = " ";

            for(int j = 1; j <= S.length(); j++){
                for(int k = 0; k <= S.length() - j; k++){

                    if(history.indexOf(" " + S.substring(k, k + j)+ " ") < 0){

                        history += S.substring(k, k + j) + " ";
                        counter++;
                    }
                }
            }

            System.out.println(history);
            output += counter + "\n";

        }

        System.out.println(output);

    }
}
