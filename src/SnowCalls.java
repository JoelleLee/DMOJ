import java.io.*;

public class SnowCalls {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int number = Integer.parseInt(stdin.readLine());

        String output = "";
        String alphabet = "ABC DEF GHI JKL MNO PQRSTUV WXYZ";

        for(int i = 0; i < number; i++){

            String input = stdin.readLine();
            String phone = "";

            for(int j = 0; j < input.length(); j++){

                char c = input.charAt(j);

                if('0' <= c && c <= '9'){
                    phone+= c;
                }
                else if('A' <= c && c <= 'Z'){
                    phone += 1 + alphabet.indexOf(c)/4;

                }

            }
            output += phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6, 10) + "\n";

        }

        System.out.print(output);

    }
}
