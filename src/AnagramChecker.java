import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;

public class AnagramChecker {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String input = stdin.readLine();
        String input1 = "";
        String input2 = "";

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
                input1 += input.charAt(i);
            }
        }

        input = stdin.readLine();

        for(int j =0; j< input.length(); j++){
            if(input.charAt(j) >= 'A' && input.charAt(j) <= 'Z'){
                input2 += input.charAt(j);
            }
        }

        while(input2.indexOf(input1.charAt(0)) >= 0 && input1.length() > 1){

            input2 = input2.substring(0, input2.indexOf(input1.charAt(0))) + input2.substring(input2.indexOf(input1.charAt(0)) + 1);
            input1 = input1.substring(1);

        }

        if(input2.equals(input1)){
            System.out.println("Is an anagram");
        }
        else{
            System.out.println("Is not anagram");
        }

    }
}
