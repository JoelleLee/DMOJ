import java.io.*;

public class Waterpark {
    public static int pathsCount(int[][] paths, int point, int mark){

        if(point==mark){
            return 1;
        }

        int count=0;

        for(int i=0; i<paths.length; i++){
            if(paths[i][0]== point){
                count+=pathsCount(paths, paths[i][1], mark);
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int numMark = Integer.parseInt(stdin.readLine());
        int[][] paths = new int[1][2];
        String[] in = stdin.readLine().split(" ");
        int index=0;

        while(!in[0].equals("0")){
            paths[index][0] = Integer.parseInt(in[0]);
            paths[index][1] = Integer.parseInt(in[1]);
            index++;

            int[][] hold = new int[index][2];

            for(int i=0; i<index; i++){
                hold[i][0]=paths[i][0];
                hold[i][1]=paths[i][1];
            }

            paths = new int[index+1][2];
            for(int i=0; i<index; i++){
                paths[i][0]=hold[i][0];
                paths[i][1]=hold[i][1];
            }

            in = stdin.readLine().split(" ");
        }

        int x=0;

        for(int i=0; i<paths.length; i++){
            if(paths[i][0]==1){
                x+=pathsCount(paths, paths[i][1], numMark);
            }
        }

        System.out.println(x);

    }
}
