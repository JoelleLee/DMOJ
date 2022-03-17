import java.io.*;

public class KeepOnTruckin {
    static int countRoutes=0;
    public static void routes(int[] totalMotel, int position, int minDistance, int maxDistance){
        if(position==7000){
            countRoutes++;
            return;
        }

        for(int i=0; i<totalMotel.length; i++){
            if(totalMotel[i]>=position+minDistance && totalMotel[i]<=position+maxDistance){
                routes(totalMotel, totalMotel[i], minDistance, maxDistance);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int minDistance = Integer.parseInt(stdin.readLine());
        int maxDistance = Integer.parseInt(stdin.readLine());
        int n = Integer.parseInt(stdin.readLine());
        int[] totalMotel = {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};

        if(n>0){
            int[] hold = new int[totalMotel.length+n];
            for(int j=0; j<totalMotel.length; j++){
                hold[j]=totalMotel[j];
            }
            for(int i=0; i<n; i++){
                hold[totalMotel.length+i]=Integer.parseInt(stdin.readLine());
            }
            totalMotel=hold;
        }

        routes(totalMotel, 0, minDistance, maxDistance);

        System.out.println(countRoutes);

    }
}
