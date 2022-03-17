import java.io.*;

public class CrossSpiral {
    public static void setDir(int[] dir, char direction){
        dir[0]=0;
        dir[1]=0;

        if(direction=='r'){ //0,1
            dir[1]=1;
        }
        else if(direction=='d'){//1,0
            dir[0]=1;
        }
        else if(direction=='l'){//0,-1
            dir[1]=-1;
        }
        else if(direction=='u'){//'u' -1,0
            dir[0]=-1;
        }

    }
    public static char direct(boolean[][] cross, int y, int x){

        if(x+1<cross[0].length && cross[y][x+1]){
            return 'r';
        }
        else if(y+1<cross.length && cross[y+1][x]){
            return 'd';
        }
        else if(x-1>=0 && cross[y][x-1]){
            return 'l';
        }else if(y-1>=0 && cross[y-1][x]){
            return 'u';
        }

        return 't';
        //t trapped
    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int width = Integer.parseInt(stdin.readLine());
        int height = Integer.parseInt(stdin.readLine());
        int widthBox = Integer.parseInt(stdin.readLine());
        int heightBox = Integer.parseInt(stdin.readLine());
        int distance = Integer.parseInt(stdin.readLine());

        int x=widthBox;
        int y=0;

        char direction='r';
        char directionPrev='r';
        //r is right, l is left, d is down, u is up
        int[] dir = new int[2];

        setDir(dir, direction);

        boolean[][] cross = new boolean[height][width];

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                cross[i][j]=true;
            }
        }

        for(int i=0; i<heightBox; i++){
            for(int j=0; j<widthBox; j++){
                cross[i][j]=false;
                cross[cross.length-i-1][j]=false;
                cross[i][cross[0].length-j-1]=false;
                cross[cross.length-i-1][cross[0].length-j-1]=false;
            }
        }

        while(distance>0 && direction!='t'){
            cross[y][x]=false;

            int[] prev = new int[2];
            setDir(prev, directionPrev);

            if(y+dir[0]<0 || x+dir[1]<0 || y+dir[0]>=height || x+dir[1]>=width || !cross[y+dir[0]][x+dir[1]]){
                directionPrev = direction;
                direction = direct(cross, y, x);
                setDir(dir, direction);
            }
            else if(y+prev[0]<height && x+prev[1]<width && y+prev[0]>=0 && x+prev[1]>=0 && directionPrev!=direction && cross[y+prev[0]][x+prev[1]]){
                direction=directionPrev;
                setDir(dir,direction);
            }

            y+=dir[0];
            x+=dir[1];
            for(int m=0; m<height; m++){
                for(int n=0; n<width; n++){
                    if(cross[m][n]){
                        System.out.print("0 ");
                    }
                    else{
                        System.out.print("X ");
                    }
                }
                System.out.println("");
            }//display cross

            System.out.println("");
            distance--;
        }

        System.out.println(x+1);
        System.out.print(y+1);



    }
}
