import java.io.*;

public class MaximumPalindrome {
    public static boolean isPal(String word){
        for(int i=0; i<word.length()/2; i++){
            if(word.charAt(i)!=word.charAt(word.length()-i-1)){
                return false;
            }
        }

        return true;
    }
    static String history =" ";
    public static int maxPal(String substring, String word, int length){

        if(history.indexOf(" "+word+" ")>=0){
            return 0;
        }

        if(word.length()>=length){
            if(isPal(word)){
                System.out.println(word);
                history+= word+" ";
                return 1;
            }
            return 0;
        }

        history+=word+" ";

        int palCnt = 0;

        for(int i=0; i<substring.length(); i++){
            palCnt += maxPal(substring.substring(0, i) + substring.substring(i+1), word+substring.charAt(i), length);
        }

        return palCnt;
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        String string = stdin.readLine();
        int numberSubstrings = Integer.parseInt(stdin.readLine());

        for(int i=0; i<numberSubstrings; i++){
            String[] index = stdin.readLine().split(" ");
            String substring = string.substring(Integer.parseInt(index[0])-1, Integer.parseInt(index[1]));

            int numPal = 0;
            int length = substring.length();

            while(numPal==0 && length>0){
               numPal=maxPal(substring, "", length);
                history=" ";
                length--;
            }

            System.out.println(numPal);
        }

    }
}
