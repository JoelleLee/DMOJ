import java.io.*;

public class GoodInfluencers2 {
    public static int noConnect(int[][] friends, String[] yn){
        int most = -1;
        int mostConnect = 0;

        for(int i=0; i<yn.length; i++){
            if(yn[i].equals("Y")){
                int connections=0;

                for(int j=0; j<friends.length; j++){
                    if(friends[j][0]==i+1 && yn[friends[j][1]-1].equals("N")){
                        connections++;
                    }
                    else if(friends[j][1]==i+1 && yn[friends[j][0]-1].equals("N")){
                        connections++;
                    }
                }

                if(connections>mostConnect){
                    most = i;
                    mostConnect = connections;
                }
            }
        }

        return most;
    }
    static int infCost = 0;
    public static void minCost(int[][] friends, String yn, int[] price, int cost){

        if(yn.indexOf("N")<0){
            if(cost<infCost){
                infCost = cost;
            }
            return;
        }

        if(cost>=infCost){
            return;
        }

        String[] YN = yn.split("");
        int inf = noConnect(friends, YN);

        while(inf>=0){
            YN[inf] = "I";

            String ynHold = yn.substring(0, inf)+"I"+ yn.substring(inf+1);
            for(int j=0; j<friends.length; j++){
                if(friends[j][0] == inf+1 && ynHold.charAt(friends[j][1]-1)=='N'){
                    ynHold = ynHold.substring(0, friends[j][1]-1)+"Y"+ynHold.substring(friends[j][1]);
                }
                else if(friends[j][1] == inf+1 && ynHold.charAt(friends[j][0]-1)=='N'){
                    ynHold = ynHold.substring(0, friends[j][0]-1)+"Y"+ynHold.substring(friends[j][0]);
                }
            }

            minCost(friends, ynHold, price, cost+price[inf]);
            inf = noConnect(friends, YN);
        }

        return;
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int N = Integer.parseInt(stdin.readLine());
        int[][] friends = new int[N-1][2];
        int[] price= new int[N];

        for(int i=0; i<N-1; i++){
            String[] input = stdin.readLine().split(" ");
            friends[i][0] = Integer.parseInt(input[0]);
            friends[i][1] = Integer.parseInt(input[1]);
        }

        String yn = stdin.readLine();

        String[] input = stdin.readLine().split(" ");
        for(int i=0; i<N; i++){
            price[i] = Integer.parseInt(input[i]);
            infCost += price[i];
        }

        minCost(friends, yn, price, 0);
        System.out.println(infCost);

    }
}
