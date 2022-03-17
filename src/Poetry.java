import java.io.*;

public class Poetry {
    public static String getLast(String str) {

        for (int i = str.length() - 1; i > 0; i--) {

            if ("aeiou".indexOf(str.charAt(i)) >= 0 || str.charAt(i) == ' ' ) {

                while ("aeiou".indexOf(str.charAt(i)) >= 0) {
                    i--;
                }

                return str.substring(i + 1);
            }
        }

        return str;
    }


    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int number = Integer.parseInt(stdin.readLine());

        String output = "";

        for(int i = 0; i < number; i++){

            String ln1 = getLast(stdin.readLine());
            String ln2 = getLast(stdin.readLine());
            String ln3 = getLast(stdin.readLine());
            String ln4 = getLast(stdin.readLine());

            if((ln1+ln2+ln3).equals(ln4+ln4+ln4)){
                output += "perfect \n";
            }
            else if(ln1.equals(ln2) && ln3.equals(ln4)){
                output += "even \n";
            }
            else if(ln1.equals(ln3) && ln2.equals(ln4)){
                output += "cross \n";
            }
            else if(ln1.equals(ln4) && ln2.equals(ln3)){
                output += "shell \n";
            }
            else{
                output += "free \n";
            }
        }

        System.out.println(output);
    }
}
