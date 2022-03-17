import java.io.*;

public class RecursionAdd {
    public static int sum(int number){

        if(number==1){
            return 1;
        }
        return number + sum(number - 1);
    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);
        System.out.println("TOTAL: " + sum(Integer.parseInt(stdin.readLine())));
    }
}
