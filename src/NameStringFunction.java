import java.io.*;

public class NameStringFunction {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("Enter your name: ");
        String name = stdin.readLine();

        int nameLength = name.length();

        for(int i = 0; i < nameLength; i++){

            System.out.println(name.charAt(i));

        }

    }
}
