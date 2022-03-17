import java.io.*;

public class AlphbetPermutations {
    static int x=0;
    private static void arrange(String letters, int num){

        if(num==0){
            System.out.println(letters);
            return;
        }

        for(int i=0; i<x; i++){
            arrange(letters + (char)('a'+i), num-1);
        }
    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);
        int num = Integer.parseInt(stdin.readLine());
        x=num;
        arrange("", num);

    }
}
