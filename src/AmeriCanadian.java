import java.io.*;

public class AmeriCanadian {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String input = stdin.readLine();
        String output = "";

        while(!input.equals("quit!")){

            int x = input.length();
            String vowel = "aeiouy";

            if(x>4 && input.endsWith("or") && vowel.indexOf(input.charAt(x-3)) < 0){
                input = input.substring(0, x - 2) + "our";
            }

            output += input + "   ";

            input = stdin.readLine();
        }

        System.out.println(output);

    }
}
