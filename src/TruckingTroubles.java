import java.io.*;

public class TruckingTroubles {
    public static int maxWeight(int[][] roads, String destin, String history, String loop, int location, int weight){//make sure there are no loops

        //System.out.println("               "+destin);
        if(destin.equals(" ")){
            return weight;
        }

        int max = -1;

        for(int i=0; i<roads.length; i++){
            if(roads[i][0]==location|| roads[i][1]==location){

                int index = 1;
                int weightHold = weight;
                String destinHold = destin;
                String loopAdd = "";

                if(roads[i][1]==location){
                    index = 0;
                }

                if(weight==-1 || roads[i][2]<weight){
                    weightHold = roads[i][2];
                }
                //System.out.println(" history "+history+i);
                //System.out.println("("+location + " "+ roads[i][index]);
                if(history.indexOf(" "+i+" ")>=0){

                    loopAdd = history.substring(history.lastIndexOf(" "+i+" "))+i+" ";

                    //System.out.println(loopAdd);
                    //System.out.println(" loop "+loop);

                    if(loop.indexOf(loopAdd)>=0){
                        //System.out.println("ignore");
                        return -1;
                    }
                }

                int isDest = destin.indexOf(" "+roads[i][index]+" ");
                if(isDest>=0){
                    destin = destin.substring(0, isDest) + destin.substring(isDest+ (" "+roads[i][index]).length());
                }

                int resultWeight = maxWeight(roads, destin, history + i + " ", loop+loopAdd, roads[i][index], weightHold);
                destin = destinHold;

                if(max==-1 || resultWeight>max){
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

        System.out.println(maxWeight(roads, destin, " ", " ",1, -1));


    }
}
