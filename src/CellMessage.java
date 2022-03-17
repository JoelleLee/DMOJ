import java.io.*;

public class CellMessage {
    public static void main (String args[]) throws IOException {

        DataInputStream stdin = new DataInputStream(System.in);

        String key = "abc def ghi jkl mno pqrstuv wxyz";

        String output = "";
        String input = stdin.readLine();

        while (!input.equals("halt")) {
            int time = 0;

            for(int i=0; i < input.length(); i++){

                int position = key.indexOf(input.charAt(i));

                int j = i-1;

                time += (1 + position)%4;

                if(i > 0){
                    System.out.println(key.indexOf(input.charAt(j))/4);

                }


            }

            output += time + "\n";

            input= stdin.readLine();
        }

        System.out.println(output);
    }
}