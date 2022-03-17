import java.io.*;

public class AnagramChecker2 {
    public static String getPure(String str){
        String pure = "";

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){

                pure += str.charAt(i);
            }
        }
        return pure;
    }

    public static int getCount(String str, char ch){
        int count = 0;

        for(int j=0; j<str.length(); j++){

            if(str.charAt(j) == ch){

                count++;
            }
        }
        return count;
    }

    public static boolean isAnagram(String str1, String str2){

        if(str1.length() != str2.length())
            return false;

        for(int i = 0; i < str1.length(); i++){

            if(getCount(str1, str1.charAt(i)) != getCount(str2, str1.charAt(i)))

                return false;

        }
        return true;
    }

    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String input1 = getPure(stdin.readLine());
        String input2 = getPure(stdin.readLine());

       if(isAnagram(input1, input2)){
            System.out.println("Is anagram");
        }
        else{
            System.out.println("Is not anagram");
        }

    }
}
