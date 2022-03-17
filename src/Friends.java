import java.io.*;

public class Friends {
    public static void circle(int[][] friend, int position, int p1, int p2){

        if(position==p2){
            System.out.println("Yes");
            return;
        }
        else if(position==p1){
            System.out.println("No");
            return;
        }

        int count = 0;

        for(int i=0; i<friend.length; i++){
            if(friend[i][0]==position){
                circle(friend, friend[i][1], p1, p2);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int studentNum = Integer.parseInt(stdin.readLine());
        int[] student= new int[studentNum];
        int[][] friend= new int[studentNum][2];

        for(int i=0; i<studentNum; i++){
            String[] hold = stdin.readLine().split(" ");
            friend[i][0] = Integer.parseInt(hold[0]);
            friend[i][1] = Integer.parseInt(hold[1]);
        }

        String[] hold = stdin.readLine().split(" ");

        while(!hold[0].equals("0")){
            for(int i=0; i<studentNum; i++){
                if(student[i]==Integer.parseInt(hold[0])){
                    circle(friend, friend[i][1], Integer.parseInt(hold[0]), Integer.parseInt(hold[1]));
                }
            }

            hold = stdin.readLine().split(" ");
        }

    }
}
