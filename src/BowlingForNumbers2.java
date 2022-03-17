import java.io.*;

public class BowlingForNumbers2 {
    public static int possibleScores(int[] pins, String history, int score, int index, int ballCount, int ballWidth){

        if(ballCount<=0){
            System.out.println(score + "    " + history);
            return score;
        }

        int highest = 0;

        for(int i=index; i<=pins.length-ballWidth; i++) {

            int knockedScore = 0;
            int[] knocked = new int[ballWidth];
            String knockedHistory="";

            for(int j=0; j<ballWidth; j++){
                knockedScore += pins[i+j];
                knocked[j]=pins[i+j];
                knockedHistory+=pins[i+j]+" ";
                pins[i+j]=0;
            }

            int result = possibleScores(pins, history+"="+knockedHistory, score + knockedScore, i, ballCount - 1, ballWidth);

            if(highest<result){
                highest = result;
            }

            for(int j=0; j<ballWidth; j++){
                pins[i+j]=knocked[j];
            }
        }

        return highest;
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int testCase = Integer.parseInt(stdin.readLine());

        for(int i=0; i<testCase; i++){

            String[] input = stdin.readLine().split(" ");

            int pinCount = Integer.parseInt(input[0]);
            int ballCount = Integer.parseInt(input[1]);
            int ballWidth = Integer.parseInt(input[2]);

            int[] pins= new int[pinCount+2*ballWidth-1];

            for(int j=ballWidth; j<pinCount+ballWidth; j++){
                pins[j] = Integer.parseInt(stdin.readLine());
            }

            int highScore = possibleScores(pins, "", 0, 0, ballCount, ballWidth);
            System.out.println(highScore);

        }

    }
}
