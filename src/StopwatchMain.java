import java.io.*;

public class StopwatchMain {
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        System.out.println("input number of stopwatches: ");

        int input = Integer.parseInt(stdin.readLine());

        while(input>0){
            for(int i=0; i<input; i++){
                Stopwatch stopwatch = new Stopwatch();
            }

            input = Integer.parseInt(stdin.readLine());
        }



    }
}
