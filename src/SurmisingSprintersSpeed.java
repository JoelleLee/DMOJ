import java.io.*;

public class SurmisingSprintersSpeed {
    public static double absoluteVal(double number){
        if(number>=0){
            return number;
        }
        return number*-1;
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int N = Integer.parseInt(stdin.readLine());
        double[][] data = new double[N][2];
        double bestSpeed = 0;

        for(int i=0; i<N; i++){
            String[] input = stdin.readLine().split(" ");
            data[i][0] = Integer.parseInt(input[0]);
            data[i][1] = Integer.parseInt(input[1]);
        }

        for(int i=0; i<N; i++){
            double[] hold = {data[i][0], data[i][1]};

            for(int j=i+1; j<N; j++){
                double speed = absoluteVal((data[j][1]-hold[1])/(data[j][0]-hold[0]));
                if(speed>bestSpeed){
                    bestSpeed = speed;
                }
            }
        }

        System.out.println(bestSpeed);
    }
}
