import java.io.*;

public class GpsTextEntry {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);
        String input = stdin.readLine();
        int cnt = 0;
        int pX=0;
        int pY=0;

        char[][] grid = {   {'A', 'B', 'C', 'D', 'E', 'F'},
                            {'G', 'H', 'I', 'J', 'K', 'L'},
                            {'M', 'N', 'O', 'P', 'Q', 'R'},
                            {'S', 'T', 'U', 'V', 'W', 'X'},
                            {'Y', 'Z', ' ', '-', '.', '/'}
        };

        for(int i=0; i<input.length(); i++){

            for(int y=0; y<grid.length; y++){
                int x=0;

                while(grid[y][x]!=input.charAt(i) && x<5){
                    x++;
                }

                if(grid[y][x]==input.charAt(i)){

                    if(pX>x){
                        cnt += pX-x;
                    }
                    else if(x>pX){
                        cnt += x-pX;
                    }

                    if(pY>y){
                        cnt += pY-y;
                    }
                    else if(y>pY){
                        cnt += y-pY;
                    }

                    pX=x;
                    pY=y;

                }

            }
        }

        cnt+= (5-pX) + (4-pY);

        System.out.println(cnt);

    }
}
