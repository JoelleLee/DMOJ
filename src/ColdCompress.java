import java.io.*;

public class ColdCompress {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int lines = Integer.parseInt(stdin.readLine());

        String output = "";

        for(int i = 0; i < lines; i++){

            String input = stdin.readLine();

            int counter = 1;

            char type = input.charAt(0);

            for(int j = 1; j < input.length(); j++){

                if(type != input.charAt(j)){
                    output += counter + " " + type + " ";

                    type = input.charAt(j);
                    counter = 1;
                }
                else{
                    counter++;
                }

            }
            output += counter + " " + type + "\n";

            }

        System.out.println(output);
    }
}
