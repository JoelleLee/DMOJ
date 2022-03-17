import java.io.*;

public class PinballPrep {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int[] scores = new int[4];
        String[] names = new String[4];

        for(int i =0; i<scores.length; i++){
            names[i] = stdin.readLine();
            scores[i] = Integer.parseInt(stdin.readLine());
        }

        for(int i=0; i<scores.length; i++){
            int rank = 1;

            for(int j=0; j<scores.length; j++){
                if(scores[i]<scores[j]){
                    rank++;
                }
            }

            System.out.println(names[i] + " " + rank);
        }


    }
}
