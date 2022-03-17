import java.io.*;

public class StringTest {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.println("Enter your name: ");
            String sentence = stdin.readLine();

        System.out.println(sentence);
        System.out.println("The length of the sentence is " + sentence.length() + ".");

        System.out.println("First n comes at " + sentence.indexOf('l') + "th time.");
        System.out.println("Second n comes at " + sentence.indexOf('a', 5) + "th time");

        System.out.println("The fifth letter is " + sentence.charAt(5) + ".");
        System.out.println("3-7 letters are " + sentence.substring(3, 7) + ".");

        System.out.println("5- end letters " + sentence.substring(5));
        System.out.println("z comes at " + sentence.indexOf('z') + ".");
        System.out.println(sentence.equals("Your Name"));




    }
}
