import java.io.*;

public class SelectionSort {
    public static void main(String args[]) throws IOException{

        int[] array = {101, 96, 129, 88, 7, 99, 54};

        for(int i=0; i<array.length-1; i++){
            int min = i;
            for(int j=i; j<array.length-1; j++){
                if(array[min]>array[j]){
                    min = j;
                }
            }

            if(min!=i){
                int holder = array[i];
                array[i] = array[min];
                array[min] = holder;
            }

            System.out.print(array[i] + " ");
        }




    }
}
