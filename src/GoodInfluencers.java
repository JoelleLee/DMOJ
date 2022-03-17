import java.io.*;
public class GoodInfluencers {
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

        for(int i=0; i<yn.length(); i++){
            if(yn.charAt(i)=='Y'){
                String[] YN = yn.split("");
                YN[i] = "I";
                for(int j=0; j<friends.length; j++){
                    if(friends[j][0] == i+1 && YN[friends[j][1]-1].equals("N")){
                        YN[friends[j][1]-1]="Y";
                    }
                    else if(friends[j][1] == i+1 && YN[friends[j][0]-1].equals("N")){
                        YN[friends[j][0]-1]="Y";
                    }
                }

                String ynHold = "";
                for(int j=0; j<YN.length; j++){
                    ynHold+=YN[j];
                }

                minCost(friends, ynHold, price, cost+price[i]);
            }
        }
        return;
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int N = Integer.parseInt(stdin.readLine());
        int[][] friends = new int[N-1][2];
        int[] cost= new int[N];

        for(int i=0; i<N-1; i++){
            String[] input = stdin.readLine().split(" ");
            friends[i][0] = Integer.parseInt(input[0]);
            friends[i][1] = Integer.parseInt(input[1]);
        }

        String YN = stdin.readLine();

        String[] input = stdin.readLine().split(" ");
        for(int i=0; i<N; i++){
            cost[i] = Integer.parseInt(input[i]);
            infCost += cost[i];
        }
        minCost(friends, YN, cost, 0);
        System.out.println(infCost);

    }
}
