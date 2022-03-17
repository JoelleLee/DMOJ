import java.io.*;

public class BowlingForNumbers {
    public static int possibleScores(int[] pins, int index, int score, int ballCount, int ballWidth){

        if(ballCount<=0){
            return score;
        }

        int highest = 0;

        for(int i=index; i<=pins.length-ballWidth; i++) {

            int knockedScore = 0;
            int[] history = new int[ballWidth];

            for(int j=0; j<ballWidth; j++){
                knockedScore += pins[i+j];
                history[j]=pins[i+j];
                pins[i+j]=0;
            }

            int result = possibleScores(pins, i,score + knockedScore, ballCount - 1, ballWidth);
            if(highest<result){
                highest = result;
            }

            for(int j=0; j<ballWidth; j++){
                pins[i+j]=history[j];
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

            int[] pins= new int[pinCount+4];

            for(int j=2; j<pinCount+2; j++){
                pins[j] = Integer.parseInt(stdin.readLine());
            }

            System.out.println(possibleScores(pins, 0,0, ballCount, ballWidth));

        }

    }
}
