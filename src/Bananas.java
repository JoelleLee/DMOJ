import java.io.*;

public class Bananas {
    public static boolean checkWord(String str){

        int NAposition = str.indexOf("ANA");

        while(!str.equals("BAS") && !str.equals("A") && NAposition >=0){

            str = str.substring(0, NAposition) + "A" + str.substring(NAposition + 3);
            NAposition = str.indexOf("ANA");
        }

        if(str.equals("BAS") || str.equals("A")){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);
        String output = "";
        String word = stdin.readLine();

        while(!word.equals("X")){

            if(checkWord(word)){
                output += "YES \n";
            }
            else{
                output += "NO \n";
            }

            word = stdin.readLine();
        }

        System.out.println(output);

    }
}
