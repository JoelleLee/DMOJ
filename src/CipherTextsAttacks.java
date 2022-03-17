import java.io.*;

public class CipherTextsAttacks {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String english = stdin.readLine();
        String code = stdin.readLine();
        String secret = stdin.readLine();

        String translation = "";

        for(int i = 0; i < secret.length(); i++){

            char letter = secret.charAt(i);

            if(code.indexOf(letter) >= 0){
                translation += english.charAt(code.indexOf(letter));

            }
            else{
                translation += ".";

            }

        }

        System.out.print(translation);

    }
}
