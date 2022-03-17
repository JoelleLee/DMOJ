import java.io.*;

public class GpsTextEntry2 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
    }

    public static Point getLocation(char c){

        Point pnt;

        char[][] grid = {   {'A', 'B', 'C', 'D', 'E', 'F'},
                            {'G', 'H', 'I', 'J', 'K', 'L'},
                            {'M', 'N', 'O', 'P', 'Q', 'R'},
                            {'S', 'T', 'U', 'V', 'W', 'X'},
                            {'Y', 'Z', ' ', '-', '.', '/'}
        };

        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j]==c){
                    return new Point(i,j);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        String in = stdin.readLine() + "/";
        int cnt = 0;
        Point prev = new Point(0,0);

        for(int i=0; i<in.length(); i++){

            Point curr = getLocation(in.charAt(i));
            cnt += Math.abs(curr.getX() - prev.getX()) + Math.abs(curr.getY() - prev.getY());

            prev = curr;
        }

        System.out.println(cnt);
    }
}
