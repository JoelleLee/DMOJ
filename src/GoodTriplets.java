import java.io.*;

public class GoodTriplets {
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        String[] input = stdin.readLine().split(" ");
        int numPts = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        input = stdin.readLine().split(" ");
        int[] point = new int[numPts];

        for(int i=0; i<numPts; i++){
            point[i] = Integer.parseInt(input[i]);
        }

        int count = 0;

        for(int i=0; point[i]<C/2; i++){
            for(int j=i+1; j<point.length && point[j]<point[i]+C/2; j++){
                for(int k=j+1; k<point.length; k++){
                    if((point[k]+C-point[i])%C>C/2 && (point[k]+C-point[j])%C<C/2){
                        System.out.println(point[i]+" "+point[j]+" "+point[k]);
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }
}
