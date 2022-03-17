import java.io.*;

public class QuantumOperations {
    public static String stats(int[][] m1){
        int[] colSum= new int[m1[0].length];
        int maxRow=0;
        int minRow=0;
        int maxCol=0;
        int minCol=0;
        int maxE=m1[0][0];
        int minE=m1[0][0];

        for(int i=0; i<m1.length; i++) {
            int rowSum= 0;
            for (int j = 0; j<m1[0].length; j++) {
                int compare=m1[i][j];

                colSum[j]+=compare;
                rowSum+=compare;

                if(maxE<compare){
                    maxE=compare;
                }
                if(minE>compare){
                    minE=compare;
                }
            }

            if(i==0 || rowSum>maxRow){
                maxRow=rowSum;
            }
            if(i==0 || rowSum<minRow){
                minRow=rowSum;
            }
        }

        for(int i=0; i<m1.length; i++){
            if(i==0 || colSum[i]>maxCol){
                maxCol=colSum[i];
            }
            if(i==0 || colSum[i]<minCol){
                minCol=colSum[i];
            }
        }

        return maxE + "\n" + minE +  "\n" + maxRow + "\n" + minRow + "\n" + maxCol + "\n" + minCol;
    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int nMatrix = Integer.parseInt(stdin.readLine());

        String[] rc = stdin.readLine().split(" ");//rows and columns
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);
        int[][] m1 = new int[r][c];

        for(int i=0; i<r; i++){
            String[] input = stdin.readLine().split(" ");
            for(int j=0; j<c; j++){
                m1[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int z=0; z<nMatrix-1; z++){
            //getting second matrix
            rc = stdin.readLine().split(" ");
            r = Integer.parseInt(rc[0]);
            c = Integer.parseInt(rc[1]);
            int[][] m2 = new int[r][c];

            for(int i=0; i<r; i++){
                String[] input = stdin.readLine().split(" ");
                for(int j=0; j<c; j++){
                    m2[i][j] = Integer.parseInt(input[j]);
                }
            }

            //finding the tensor product
            int[][] product = new int[m1.length*r][m1[0].length*c];
            for(int i=0; i<m1.length; i++) {
                for (int j=0; j<m1[0].length; j++) {
                    for(int k=0; k<r; k++){
                        for(int l=0; l<c; l++){
                            product[i*r+k][j*c+l] = m1[i][j] * m2[k][l];
                        }
                    }
                }
            }

            m1=product;
        }

        System.out.println(stats(m1));

    }
}
