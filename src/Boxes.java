import java.io.*;

public class Boxes {
    public static void dimentionSort(int[] a){
        for(int i=1; i<a.length; i++){
            int p=i-1;
            int h= a[i];

            while(p>=0 && h<a[p]){
                a[p+1] = a[p];
                p--;
            }
            a[p+1] = h;
        }

    }
    public static void boxSort(int[][] sBox){
        for(int i=1; i<sBox.length; i++) {
            int c = i - 1;
            int[] current = sBox[i];

            while (c >= 0 && sBox[c][3] > current[3]) {
                sBox[c + 1] = sBox[c];
                c--;
            }
            sBox[c+1] = current;
        }

    }
    public static int smallestBox(int[][] sBox, int[] sItem){

        for(int i=0; i<sBox.length; i++){
            if(sBox[i][0]>=sItem[0] && sBox[i][1]>=sItem[1] && sBox[i][2]>=sItem[2]){
                return sBox[i][3];
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int nBox = Integer.parseInt(stdin.readLine());
        int[][] sBox = new int[nBox][4];
        //column 0 length   1 width     2 height     3 volume
        String in = "";

        for(int i =0; i<nBox; i++){
            in = stdin.readLine();
            String[] input = in.split(" ");

            for(int j=0; j<3; j++){
                sBox[i][j] = Integer.parseInt(input[j]);
            }

            sBox[i][3] = sBox[i][0]*sBox[i][1]*sBox[i][2];
            dimentionSort(sBox[i]);
        }

        int nItem = Integer.parseInt(stdin.readLine());
        int[][] sItem = new int[nItem][3];

        for(int z=0; z<nItem; z++){
            in = stdin.readLine();
            String[] input = in.split(" ");

            for(int j=0; j<3; j++){
                sItem[z][j] = Integer.parseInt(input[j]);
            }
            dimentionSort(sItem[z]);
        }

        boxSort(sBox);

        for(int i=0; i<nItem; i++){
            int boxVolume = smallestBox(sBox, sItem[i]);

            if(boxVolume == -1){
                System.out.println("Item does not fit");
            }
            else{
                System.out.println(boxVolume);
            }

        }

    }
}
