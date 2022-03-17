import java.io.*;

public class StudentRanking2D {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String[] name = new String[5];
        int[][] grade = new int[name.length][4];
        //column0=math     column1=english    column2=science   column3=total

        for(int i=0; i<name.length; i++){

            name[i]= stdin.readLine();
            int total=0;
            for(int j=0; j<3; j++){
                grade[i][j] = Integer.parseInt(stdin.readLine());
                total+= grade[i][j];
            }
            grade[i][3] = total;

        }

        System.out.println("name  english  math  science  total  average");

        for(int k=1; k<name.length; k++){

            int p = k-1;
            int[] holder = grade[k];
            String hName = name[k];

            while(p>=0 && holder[3]>grade[p][3]){

                grade[p+1] = grade[p];
                name[p+1] = name[p];
                p--;

            }

            grade[p+1] = holder;
            name[p+1] = hName;

        }

        for(int l=0; l<name.length; l++){
            System.out.println(l+1 + ", "+ name[l] + ", "+ grade[l][0] + ", "+ grade[l][1] + ", science "+ grade[l][2] + ", total "+ grade[l][3] + ", average " + grade[l][3]/3.0);
        }
    }
}
//divide /3.0, title name english math   output just marks
