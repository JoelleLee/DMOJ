import java.io.*;

public class FirstLastName {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("Input name: ");
        String name = stdin.readLine();

        int indexOfSplit = name.indexOf(" ");

        String first = name.substring(0, indexOfSplit);
        String last = name.substring(indexOfSplit + 1);

        System.out.print("Welcome Ms." + last + ", " + first);



    }
}
