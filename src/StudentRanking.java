import java.io.*;

public class StudentRanking {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String[] name = new String[5];
        int[] math = new int[name.length];
        int[] english = new int[name.length];
        int[] science = new int[name.length];
        int[] total = new int[name.length];

        for(int i=0; i<name.length; i++){
            name[i]= stdin.readLine();
            math[i]= Integer.parseInt(stdin.readLine());
            english[i]= Integer.parseInt(stdin.readLine());
            science[i]= Integer.parseInt(stdin.readLine());
            total[i] = math[i] + english[i] + science[i];
        }

        for(int i=1; i<name.length; i++){
            int holderT = total[i];
            int hE = math[i];
            int hM = english[i];
            int hS = science[i];
            String holderN = name[i];
            int p = i-1;

            while(p>=0 && total[p]<holderT){
                total[p+1] = total[p];
                name[p+1] = name[p];
                english[p+1] = english[p];
                math[p+1] = math[p];
                science[p+1] = science[p];
                p--;
            }

            total[p+1] = holderT;
            name[p+1] = holderN;
            english[p+1] = hE;
            math[p+1] = hM;
            science[p+1] = hS;

        }

        for(int i=0; i<total.length; i++){
            System.out.println(i+1 + ", name "+ name[i] + ", english "+ english[i] + ", math "+ math[i] + ", science "+ science[i] + ", total "+ total[i] + ", average " + total[i]/3);
        }

    }
}
