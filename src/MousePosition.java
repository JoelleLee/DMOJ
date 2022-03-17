import java.io.*;

public class MousePosition {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("input c (c,r): ");
        int c = Integer.parseInt(stdin.readLine());

        System.out.print("input r (c,r): ");
        int r = Integer.parseInt(stdin.readLine());

        int pX = 0;
        int pY = 0;

        System.out.print("input x: ");
        int x = Integer.parseInt(stdin.readLine());

        System.out.print("input y: ");
        int y = Integer.parseInt(stdin.readLine());

        while(x != 0 || y != 0){

            pX += x;
            pY += y;

            if(pX > c){
                pX = c;
            }
            else if(pX < 0){
                pX = 0;
            }

            if(pY > r){
                pY = r;
            }
            else if(pY < 0){
                pY = 0;
            }

            System.out.println("(" + pX + ", " + pY + ") ");

            System.out.print("input x: ");
            x = Integer.parseInt(stdin.readLine());

            System.out.print("input y: ");
            y = Integer.parseInt(stdin.readLine());

        }



    }
}
