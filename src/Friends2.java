import java.io.*;

public class Friends2 {
    public static int circle(int[][] relations, String history, int friend, int targetFriend, int count){

        if(friend==targetFriend){
            return count;
        }

        if(history.indexOf(" "+friend+" ")>=0){
            return -1;
        }

        for(int i=0; i<relations.length; i++){
            if(relations[i][0]==friend){
                return circle(relations, history + friend+" ", relations[i][1], targetFriend, count++);
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        DataInputStream stdin = new DataInputStream(System.in);

        int studentNum = Integer.parseInt(stdin.readLine());
        int[][] friend= new int[studentNum][2];

        for(int i=0; i<studentNum; i++){
            String[] pair = stdin.readLine().split(" ");
            friend[i][0] = Integer.parseInt(pair[0]);
            friend[i][1] = Integer.parseInt(pair[1]);
        }

        String[] pair = stdin.readLine().split(" ");

        while(!pair[0].equals("0")){

            int friendDistance = circle(friend, " ", Integer.parseInt(pair[0]), Integer.parseInt(pair[1]), 0);

            if(friendDistance>=0){
                System.out.println("Yes "+friendDistance);
            }
            else{
                System.out.println("No");
            }

            pair = stdin.readLine().split(" ");
        }

    }
}
