import java.io.*;

public class ReturningHome {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);
        String[] direction = new String[5];
        String[] street = new String[6];
        int n = 0;

        //use one array to log direction and street.. stack and queue
        street[0] = "HOME";
        while(!street[n].equals("SCHOOL")){
            direction[n] = stdin.readLine();
            street[n+1] = stdin.readLine();
            n++;
        }

        for(int i=n-1; i>=0; i--){
            if(direction[i].equals("R")){
                System.out.println("Turn Left to " + street[i] + " street.");
            }
            else{
                System.out.println("Turn Right to " + street[i] + " street.");
            }

        }

    }
}
