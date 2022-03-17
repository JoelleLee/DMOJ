import java.io.*;
public class CellPhoneMessage {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String key = "abc def ghi jkl mno pqrstuv wxyz";

        String output = "";
        String input = stdin.readLine();

        while(!input.equals("halt")){
            int time = 0;

            for(int i = 0; i < input.length(); i++){

                int position = key.indexOf(input.charAt(i));

                time += (1 + position)%4;

                if(i > 0 && position/4 == key.indexOf(input.charAt(i - 1))/4){
                    time+= 2;

                }
            }

            output += time + "\n";

            input = stdin.readLine();

        }

        System.out.println(output);

    }
}
