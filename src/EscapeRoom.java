import java.io.*;

public class EscapeRoom {
    public static void canEscape(int[][] room, int r, int c){

        if(r==room.length-1 && c==room[0].length-1){
            room[r][c] = -1;
            return;
        }

        for(int i=0; i<room.length; i++){
            for(int j=0; j<room[0].length; j++){

                System.out.println("("+i+" "+j+") "+ (i+1)*(j+1) + " " + room[r][c]);

                if((i+1)*(j+1)==room[r][c] && !(i==r && j==c)){
                    room[r][c] = -1;
                    {
                        for(int n=0; n<room.length; n++){
                            for(int m=0; m<room[0].length; m++){
                                System.out.print(room[n][m]+" ");
                            }
                            System.out.println("");
                        }
                        System.out.println("");

                    }
                    canEscape(room, i, j);
                    return;
                }
            }
        }


    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int M = Integer.parseInt(stdin.readLine());
        int N = Integer.parseInt(stdin.readLine());
        int[][] room = new int[M][N];

        for(int r=0; r<M; r++){
            String[] input = stdin.readLine().split(" ");
            for(int c=0; c<N; c++){
                room[r][c] = Integer.parseInt(input[c]);
            }
        }

        canEscape(room, 0, 0);

        if(room[M-1][N-1]==-1){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }

    }
}
