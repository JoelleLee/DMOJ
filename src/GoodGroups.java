import java.io.*;

public class GoodGroups {
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int X = Integer.parseInt(stdin.readLine());
        String[][] constX = new String[X][2];

        for(int i=0; i<X; i++){
            String[] pairs = stdin.readLine().split(" ");
            constX[i][0] = pairs[0];
            constX[i][1] = pairs[1];
        }//getting constraint 1

        int Y = Integer.parseInt(stdin.readLine());
        String[][] constY = new String[Y][2];

        for(int i=0; i<Y; i++) {
            String[] pairs = stdin.readLine().split(" ");
            constY[i][0] = pairs[0];
            constY[i][1] = pairs[1];
        }//getting constraint 2

        int G = Integer.parseInt(stdin.readLine());
        int last = X;
        int violations = 0;

        for(int i=0; i<G; i++){
            String group = " " +stdin.readLine()+" ";//getting groups and checking each constraint

            for(int j=0; j<last; j++){
                if(!constX[j][0].equals("") && group.indexOf(" "+constX[j][0]+" ")>=0 && group.indexOf(" "+constX[j][1]+" ")>=0){
                    constX[j][0]=constX[last-1][0];
                    constX[j][1]=constX[last-1][0];
                    constX[last-1][0]="";
                    constX[last-1][1]="";
                    last--;
                }
            }

            int m=Y;
            for(int j=0; j<m; j++){
                if(!constY[j][0].equals("") && group.indexOf(" "+constY[j][0]+" ")>=0 && group.indexOf(" "+constY[j][1]+" ")>=0){
                    constY[j][0]=constY[m-1][0];
                    constY[j][1]=constY[m-1][0];
                    constY[m-1][0]="";
                    constY[m-1][1]="";
                    violations++;
                }
            }
        }

        System.out.println(last + violations);


    }
}
