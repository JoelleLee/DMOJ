import java.io.*;

public class Maternity {

    public static String getOut(String str, String str1, String str2){

        for(int j = 1; j<= 10; j+=2) {

            boolean b = str.charAt(j/2) >= 'a' && str.charAt(j/2) <= 'e';

            boolean p1Check = ('A' <= str1.charAt(j) && str1.charAt(j) <= 'E') || ('A' <= str2.charAt(j) && str2.charAt(j) <= 'E');
            boolean p1Check2 = 'a' <= str1.charAt(j) && str1.charAt(j) <= 'e' && 'a' <= str2.charAt(j) && str2.charAt(j) <= 'e';

            if (str1.charAt(j) == str1.charAt(j-1) && ((p1Check && b) || (p1Check2 && !b)))
                return "Not their baby!\n";

        }

     return "Possible baby.\n";
    }

    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        String p1 = stdin.readLine();
        String p2 = stdin.readLine();

        int X = Integer.parseInt(stdin.readLine());

        String output = "";

        for(int i = 0; i<X; i++){

            String baby = stdin.readLine();
            output += getOut(baby, p1, p2);

        }

        System.out.println(output);
    }
}

