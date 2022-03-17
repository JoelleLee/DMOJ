import java.io.*;

public class Main {
    public static int samples(String notes, int M){
        String history = ".";
        String[] note = notes.split(" ");
        int count = 0;

        for(int i=0; i<note.length; i++){
            String check = "";
            for(int j=i; j<note.length; j++){

                if(check.indexOf(note[j])<0){
                    check+= note[j] +" ";
                    count++;
                }
                else{
                    j=note.length;
                }
            }
        }

        return count;
    }
    public static String composition(int N, int M, int K, String notes){

        if(notes.split(" ").length>=N+1){
            return notes;
        }

        String composition = "";
        for(int i=1; i<=M; i++){

            if(notes.equals("") || !notes.substring(notes.lastIndexOf(" ") ).equals(" "+i)){
                composition = composition(N, M, K, notes+" "+i);

                if(!composition.equals(" -1") && samples(composition.substring(1), M)>=K){
                    return composition;
                }
            }
        }

        return " -1";
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        String[] input = stdin.readLine().split(" ");
        int notes = Integer.parseInt(input[0]);
        int range = Integer.parseInt(input[1]);
        int samples = Integer.parseInt(input[2]);

        System.out.println(composition(notes, range, samples, "").substring(1));

    }
}
