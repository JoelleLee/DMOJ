import java.io.*;

public class Maternity3 {

    public static int getDecide(char f, char m){

        if(f>='a' && m>='a'){
            return 1;
        }

        return 2;
    }

    public static int getDNA(String dad, String mom){

        int out = 0;

        for(int i = 0; i<2; i++){

            for(int j = 0; j<2; j++){

                out += getDecide(dad.charAt(i), mom.charAt(j));
            }
        }

        if(out == 4){
            return 1;
        }
        else if(out == 8){
            return 2;
        }

        return 3;
    }

    public static String getMap(String father, String mother){

        String map = "";

        for(int i = 0; i < 10; i+=2){
            map += getDNA(father.substring(i, i+2), mother.substring(i, i+2));

        }

        return map;
    }

    public static boolean isPossible(String map, String baby){

        for(int i = 0; i<5; i++){
            if((map.charAt(i) =='2'&& baby.charAt(i)>='a')|| (map.charAt(i)=='1' && baby.charAt(i)<='E')){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String p1 = stdin.readLine();
        String p2 = stdin.readLine();
        int b = Integer.parseInt(stdin.readLine());
        String map = getMap(p1,p2);
        String output = "";

        for(int i = 0; i < b; i++){

            String baby = stdin.readLine();

            if(isPossible(getMap(p1,p2), baby)){
                output += "Is possible.\n";
            }
            else{
                output += "Is not baby! \n";
            }
        }

        System.out.println(output);

    }
}
