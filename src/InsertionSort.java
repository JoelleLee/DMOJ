import java.io.*;

public class InsertionSort {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int[] array = {3, 2, 5, 8, 7};
        int hold = 0;

        for(int i = 1; i<array.length; i++){
            hold = array[i];
            int p=i-1;

            while(p>=0 && hold>array[p]){
                array[p+1] = array[p];
                p--;
            }

            array[p+1] = hold;
        }

        for(int j=0; j<array.length; j++){
            System.out.println(array[j] + " ");
        }
    }
}
