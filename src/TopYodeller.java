import java.io.*;

public class TopYodeller {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int n =Integer.parseInt(stdin.readLine());
        int k =Integer.parseInt(stdin.readLine());
        String input = "";

        int[][] score = new int[k][n];

        for(int i=0; i<k; i++){
            int from = 0;
            input = stdin.readLine()+" ";
            String[] nums = input.split(" ");

            for(int j=0; j<n; j++){
                if(i==0){
                    score[i][j] = Integer.parseInt(nums[j]);
                }
                else{
                    score[i][j] = Integer.parseInt(nums[j]) + score[i-1][j];
                }

            }
        }

        int top=0;
        for(int i=0; i<n; i++){
            if(score[k-1][i] >= score[k-1][top]){
                top = i;
            }
        }

        for(int z=0; z<=top; z++){

            if(score[k-1][top]==score[k-1][z]){
                int worst=0;
                for(int i=0; i<k-1; i++){
                    int rank=1;
                    for(int j=0; j<n; j++){
                        if(score[i][z]<score[i][j]){
                            rank++;
                        }
                    }

                    if(rank>worst){
                        worst=rank;
                    }
                }
                System.out.println("Yodeller " + (z + 1) + " it the TopYodeller: score " + score[k-1][z]+ ", worst rank " + worst);
            }
        }


    }
}
