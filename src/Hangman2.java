import java.io.*;

public class Hangman2 {

    public static String getX(String str){

        String out = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                out += "*";
            } else {
                out += str.charAt(i);
            }
        }

        System.out.println(out);

        return out;
    }

    public static void main(String[] args) throws IOException {

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("answer : ");
        String answer = stdin.readLine();
        String output = getX(answer);

        int life = 5;

        while (life > 0 && !answer.equals(output)) {

            System.out.print("guess : ");
            String input = stdin.readLine();
            int index = answer.indexOf(input);

            if (index < 0){
                life--;
                System.out.println(input + " is not found\nyou have " + life + " lives");
            }
            else{
                while(index >= 0){
                    output = output.substring(0, index) + input + output.substring(index + 1);
                    index = answer.indexOf(input, index + 1);
                }
                System.out.println(output);
            }

        }

        if(answer.equals(output)){
            System.out.printf("YOU WIN");
        }
        else {
            System.out.printf("YOU LOSE");
        }
    }
}
