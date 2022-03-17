import java.io.*;

public class TruckingTroubles2 {
    public static int maxWeight(int[][] roads, String destin, String history, int location0, int location1, int weight){

        if((history).indexOf(" "+location0+" "+location1+" ")>=0){
            return 0;
        }

        history+=location1+" ";

        int isDest = destin.indexOf(" "+location1+" ");
        if(isDest>=0){
            destin = destin.substring(0, isDest) + destin.substring(isDest+ (" "+location1).length());
        }

        if(destin.equals(" ")){
            System.out.println(history+" "+location1);
            return weight;
        }

        int max = 0;
        location0=location1;

        for(int i=0; i<roads.length; i++){
            if(roads[i][0]==location0 || roads[i][1]==location0){

                location1=roads[i][0];
                if(roads[i][0]==location0) {
                    location1=roads[i][1];
                }

                int weightHold = weight;
                if(weight==0 || roads[i][2]<weight){
                    weightHold = roads[i][2];
                }

                int resultWeight = maxWeight(roads, destin, history, location0, location1, weightHold);
                if(resultWeight>max){
                    max = resultWeight;
                }
            }
        }

        return max;
    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String[] input = stdin.readLine().split(" ");
        int cityNum = Integer.parseInt(input[0]);
        int roadNum = Integer.parseInt(input[1]);
        int destNum = Integer.parseInt(input[2]);

        int[][] roads = new int[roadNum][3];
        String destin = " ";

        for(int i=0; i<roadNum; i++){
            input= stdin.readLine().split(" ");
            roads[i][0] = Integer.parseInt(input[0]);
            roads[i][1] = Integer.parseInt(input[1]);
            roads[i][2] = Integer.parseInt(input[2]);
        }

        for(int i=0; i<destNum; i++){
            destin+=stdin.readLine()+" ";
        }

        System.out.println(maxWeight(roads, destin, " ", 1, 1, 0));
    }
}
