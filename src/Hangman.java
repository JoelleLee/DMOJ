import java.io.*;

public class Hangman {

    public static String getOut(String str1, char ch, String str2){

        String out = "";

        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) == ch){
                out += ch;
            }
            else{
                out += str2.charAt(i);
            }

        }

        return out;
    }

    public static void main(String args[]) throws IOException {

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("answer : ");
        String answer = stdin.readLine();

        String output = "";

        for(int i = 0; i < answer.length(); i++) {
            if(answer.charAt(i) >= 'a' && answer.charAt(i) <= 'z'){
                output += "X";
            }
            else{
                output += answer.charAt(i);
            }
        }

        System.out.println(output);

        int life = 5;

        while(life > 0 && !output.equals(answer)){

            System.out.print("guess : ");
            char input = stdin.readLine().charAt(0);

            if(answer.indexOf(input)>=0){
                output = getOut(answer, input, output);
                System.out.println(output);
            }
            else{
                life--;
                System.out.println(input + " is not found\nyou have " +life+ " lives");
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