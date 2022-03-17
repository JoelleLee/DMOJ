import java.io.*;

public class BubbleSort {
    public static void main(String[] args) throws IOException{

        int[] array = {101, 96, 129, 88, 7, 99, 54};

        for(int i =0; i< array.length; i++){
            for(int j = 0; j< array.length-i-1; j++){
                if(array[j] > array[j+1]){
                    int holder = array[j+1];
                    array[j+1] = array[j];
                    array[j] = holder;
                }
            }
        }

        for(int j = 0; j< array.length; j++){
            System.out.print(array[j] + " ");
        }

    }
}
