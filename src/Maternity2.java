import java.io.*;

public class Maternity2 {
    public static String getSection(String str1, String str2){

        String section = str1.charAt(0) +""+ str2.charAt(0) + " " + str1.charAt(0) + str2.charAt(1) + " "  + str2.charAt(0) + str1.charAt(1) + " " + str1.charAt(1) + str2.charAt(1);
        return section;
    }
    public static String getMap(String str){

        String map = "";

        if (str.charAt(0) >= 'a' && str.charAt(1) >= 'a'){
            map += "L";
        }
        else if(str.charAt(9) <= 'E' || str.charAt(10) <= 'E'){
            map += "U";
        }
        else{
            map += "B";
        }
        return map;
    }
    public static String getResults(String str1, String str2){

        for(int i = 0; i<5; i++){
            if((str1.charAt(i) =='U'&& str2.charAt(i)>='a')|| (str1.charAt(i)=='L' && str2.charAt(i)<='E')){
                return "Not their baby!";
            }
        }
        return "Possible baby.";
    }

    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String p1 = stdin.readLine();
        String p2 = stdin.readLine();
        String map = "";
        int b = Integer.parseInt(stdin.readLine());
        String output = "";

        for(int i = 0; i < 10; i+=2){
            map += getMap(getSection(p1.substring(i, i+2), p2.substring(i, i+2)));

        }

        for(int j = 0; j < b; j++){
            String dnaBaby = stdin.readLine();
            output += getResults(map, dnaBaby) + "\n";

        }

        System.out.println(output);

    }
}
