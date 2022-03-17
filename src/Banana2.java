import java.io.*;

public class Banana2 {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String output = "";
        String input = stdin.readLine();

        while(!input.equals("X")){

            while(input.length()>1){

                if(input.indexOf("AN")==0){
                   input= input.substring(2);
                }
                else if(input.indexOf("B")==0){
                    input = input.substring(1, input.indexOf("S")) + input.substring(input.indexOf("S") +1);
                }

            }

            if(input.equals("A")){
                output+="YES \n";
            }
            else{
                output+="NO \n";
            }

            input = stdin.readLine();
        }

        System.out.println(output);
    }
}
