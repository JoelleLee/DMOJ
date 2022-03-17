import java.io.*;

public class SimpleEncryption {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String key  = stdin.readLine();

        String input = stdin.readLine();
        String letters = "";

        for(int j = 0; j < input.length(); j++){

            if(input.charAt(j) >= 'A' && input.charAt(j) <= 'Z'){
                letters += input.charAt(j);

            }
        }

        String output = "";
        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 0; i < letters.length(); i++){

            output += a.charAt((a.indexOf(key.charAt(i % key.length())) + a.indexOf(letters.charAt(i)))%26);

        }

        System.out.print(output);
    }
}
