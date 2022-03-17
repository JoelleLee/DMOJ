import java.io.*;

public class PinballRanking {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int t = Integer.parseInt(stdin.readLine());
        int[] games = new int[t];
        float average = 0;

        for(int i = 0; i<t; i++){
            int rank =1;
            games[i] = Integer.parseInt(stdin.readLine());

            for(int p=0; p<i; p++){
                if((i>0) && (games[i]<games[p])){
                    rank++;
                }
            }

            average+=rank;
        }

        System.out.println((average/t));

    }
}
