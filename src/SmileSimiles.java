import java.io.*;

public class SmileSimiles {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int n = Integer.parseInt(stdin.readLine());
        int m = Integer.parseInt(stdin.readLine());
        String[] adj = new String[n];
        String[] noun = new String[m];

        for(int i = 0; i<n; i++){
            adj[i] = stdin.readLine();
        }

        for(int j = 0; j<m; j++) {
                noun[j] = stdin.readLine();
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++) {
                System.out.println(adj[i] + " as " + noun[j]);
            }
        }

    }
}
