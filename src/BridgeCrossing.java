import java.io.*;

public class BridgeCrossing {
    static String bestGrouping = "";
    static int bestTime = 0;
    public static void groups(int[] times, String[] names, String groups, int timeCross, int index, int capacity){

        if(index>=times.length) {
            if(bestTime==0 || bestTime>timeCross){
                bestTime = timeCross;
                bestGrouping = groups;
            }

            System.out.println(timeCross + " \n" +groups);
            return;
        }

        int slowestPerson =0;

        for(int i=0; i<capacity && index+i<times.length; i++){
            groups+=names[index+i]+" ";

            if(times[index+i]>slowestPerson){
                slowestPerson = times[index+i];
            }

            groups(times, names, groups+"\n" , timeCross+slowestPerson, index+i+1, capacity);
        }
    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int capacity = Integer.parseInt(stdin.readLine());
        int size = Integer.parseInt(stdin.readLine());
        String[] names = new String[size];
        int[] times = new int[size];

        for(int i=0; i<size; i++){
            names[i] = stdin.readLine();
            times[i] = Integer.parseInt(stdin.readLine());
        }

        groups(times, names, "" ,0,  0, capacity);
        System.out.println("Total time: "+bestTime);
        System.out.println(bestGrouping);
    }
}
