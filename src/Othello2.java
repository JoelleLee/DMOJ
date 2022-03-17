import java.io.*;

public class Othello2 {
    public static void main(String[] args) throws IOException {

        DataInputStream stdin = new DataInputStream(System.in);

        String in = stdin.readLine();
        int[][] board = new int[8][8];

        //0 is empty        1 is black      2 is white
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                board[i][j]= 0;
            }
        }

        if(in.charAt(0)=='a'){
            board[3][4]= 1;
            board[4][3]= 1;
            board[3][3] = 2;
            board[4][4] = 2;
        }
        else if(in.charAt(0)=='b'){
            for(int i =0; i<8; i++){
                board[i][i]=1;
                board[7-i][i]=2;
            }
        }
        else{
            for(int i=0; i<8; i++){
                board[i][2]= 1;
                board[i][3]= 1;
                board[i][4] = 2;
                board[i][5] = 2;
            }
        }

        int white =0;
        int black =0;
        int empty = 1;
        int turn = 2;
        int antiturn=1;

        for(int z=0; z<8; z++){
            empty=0;
            for(int l=0; l<8; l++){
                if(board[z][l]==0){
                    System.out.print("_ ");
                }
                else if(board[z][l]==1){
                    System.out.print("X ");
                }
                else{
                    System.out.print("O ");
                }
            }
            System.out.println("");
        }
        System.out.println("");

        while(empty>0){
            String[] input = stdin.readLine().split(" ");
            int[] moves = new int[input.length];

            for(int i=0; i<input.length;i++){
                moves[i] = Integer.parseInt(input[i])-1;
            }

            if(turn==2){
                turn=1;
                antiturn=2;
            }
            else{
                turn=2;
                antiturn=1;
            }

            int y = moves[0];
            int x =  moves[1];

            if(turn==1){
                antiturn = 2;
            }
            else{
                antiturn = 1;
            }

            board[y][x] = turn;

            //EAST
            int h = x+1;

            while(h<7 && board[y][h]==antiturn){
                h++;
            }
            if(h<=7 && board[y][h]==turn){
                for(int z=x+1; z<h; z++){
                    board[y][z]=turn;
                }
            }

            //WEST
            h=x-1;

            while(h>0 && board[y][h]==antiturn){
                h--;
            }
            if(h>=0 && board[y][h]==turn){
                for(int z =1; h+z<x; z++){
                    board[y][h+z]=turn;
                }
            }

            //SOUTH
            int v = y+1;

            while(v<7 && board[v][x]==antiturn){
                v++;
            }
            if(v<=7 && board[v][x]==turn){
                for(int z=1; v-z>y; z++){
                    board[v-z][x] = turn;
                }
            }

            //NORTH
            v=y-1;

            while(v>0 && board[v][x]==antiturn){
                v--;
            }
            if(v>=0 && board[v][x]==turn){
                for(int z=1; z+v<y; z++){
                    board[v+z][x] = turn;
                }
            }

            //diagonal
            //SOUTH EAST
            int dy=y+1;
            int dx=x+1;

            while(dy<7 && dx<7 && board[dy][dx]==antiturn){
                dy++;
                dx++;
            }
            if(dy<=7 && dx<=7 && board[dy][dx]==turn){
                for(int z=1; dy-z>y && dx-z>x; z++){
                    board[dy-z][dx-z]=turn;
                }
            }

            //NORTH EAST
            dy=y-1;
            dx=x+1;

            while(dy>0 && dx<7 && board[dy][dx]==antiturn){
                dy--;
                dx++;
            }
            if(dy>=0 && dx<=7 && board[dy][dx]==turn){
                for(int z=1; dy+z<y && dx-z>x; z++){
                    board[dy+z][dx-z]=turn;
                }
            }

            //SOUTH WEST
            dy=y+1;
            dx=x-1;

            while(dy<7 && dx>0 && board[dy][dx]==antiturn){
                dy++;
                dx--;
            }
            if(dy<=7 && dx>=0 && board[dy][dx]==turn){
                for(int z=1; dy-z>y && dx+z<x; z++){
                    board[dy-z][dx+z]=turn;
                }
            }


            //NORTH WEST

            dy=y-1;
            dx=x-1;

            while(dy>0 && dx>0 && board[dy][dx]==antiturn){
                dy--;
                dx--;
            }
            if(dy>=0 && dx>=0 && board[dy][dx]==turn){
                for(int z=1; dy+z<y && dx+z<x; z++){
                    board[dy+z][dx+z]=turn;
                }
            }

            for(int z=0; z<8; z++){
                empty=0;
                for(int l=0; l<8; l++){
                    if(board[z][l]==0){
                        System.out.print("_ ");
                        empty++;
                    }
                    else if(board[z][l]==1){
                        System.out.print("X ");
                    }
                    else{
                        System.out.print("O ");
                    }
                }
                System.out.println("");
            }
            System.out.println("");

        }

        for(int z=0; z<8; z++){
            for(int l=0; l<8; l++){
                if(board[z][l]==1){
                    black++;
                }
                else if(board[z][l]==2){
                    white++;
                }
            }
        }
        System.out.println(black + " " + white);

    }
}


