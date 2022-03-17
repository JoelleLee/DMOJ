import java.io.*;

public class CrossSprial2 {

    static int x=0;
    static int y=0;

    public static void setDir(int[] dir, int direction){
        dir[0]=0;
        dir[1]=0;

        if(direction==0){//'u' -1,0
            dir[0]=-1;
        }
        else if(direction==1){ //0,1
            dir[1]=1;
        }
        else if(direction==2){//1,0
            dir[0]=1;
        }
        else if(direction==3){//0,-1
            dir[1]=-1;
        }

    }
    public static int move(int[][] cross, int direction, int[] dir){

        for(int i=3; i<7; i++){
            setDir(dir, (direction+i)%4);

            if(x+dir[1]>=0 && x+dir[1]<cross[0].length && y+dir[0]>=0 && y+dir[0] < cross.length && cross[y+dir[0]][x+dir[1]]==0){
                y+=dir[0];
                x+=dir[1];
                return (direction+i)%4;
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int width = Integer.parseInt(stdin.readLine());
        int height = Integer.parseInt(stdin.readLine());
        int widthBox = Integer.parseInt(stdin.readLine());
        int heightBox = Integer.parseInt(stdin.readLine());
        int distance = Integer.parseInt(stdin.readLine());

        int direction = 1;
        //North is 0, East is 1, South is 2, West is 3 //priority left, forward, right, back
        int cnt = 1;
        x=widthBox;

        int[][] cross = new int[height][width];
        int[] dir = new int[2];

        {
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    cross[i][j]=0;
                }
            }

            for(int i=0; i<heightBox; i++){
                for(int j=0; j<widthBox; j++){
                    cross[i][j]=-1;
                    cross[cross.length-i-1][j]=-1;
                    cross[i][cross[0].length-j-1]=-1;
                    cross[cross.length-i-1][cross[0].length-j-1]=-1;
                }
            }
        }//setting cross board

        while(cnt<=distance && direction!=-1){

            cross[y][x]=cnt++;
            direction= move(cross, direction, dir);

        }

        System.out.println(x+1);
        System.out.println(y+1);
    }
}
