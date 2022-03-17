import java.io.*;

public class G4G5 {
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int N = Integer.parseInt(stdin.readLine());
        int ways = 0;

        for(int i=0; i<=N; i+=5){
            if((N-i)%4==0){
                ways++;
            }
        }

        System.out.println(ways);


    }
}
