import java.io.*;

public class Othello1 {
    public static void outBoard(int[][] board, int empty){

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
    public static String countPieces(int[][] board){
        int white=0;
        int black=0;

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

        if(black>white){
            return "X is winner   X"+black+" O"+white;
        }

        return "O is winner   O"+white+" X"+black;
    }
    public static String turn(int turn){
        if(turn==1){
            return "X";
        }
        return "O";
    }
    public static boolean flip(int[][] board, int x, int y, int m, int z){

        int i=1;

        while(((m==0 && i*z+y>0 && i*z+y<7) || (z==0 && i*m+x>0 && i*m+x<7) || (i*m+x>0 && i*z+y>0 && i*m+x<7 && i*z+y<7)) && board[y+i*z][x+i*m]==-1*board[y][x]){
            i++;

            if(board[y+i*z][x+i*m]==board[y][x]){
                while(i>1){
                    board[y+(i-1)*z][x+(i-1)*m]=board[y][x];
                    i--;
                }
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.println("_ _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ _ \n" +
                "_ _ _ O X _ _ _ \n" +
                "_ _ _ X O _ _ _ \n" +
                "_ _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ _\n" +
                "  a\n");

        System.out.println("X _ _ _ _ _ _ O \n" +
                "_ X _ _ _ _ O _ \n" +
                "_ _ X _ _ O _ _ \n" +
                "_ _ _ X O _ _ _ \n" +
                "_ _ _ O X _ _ _ \n" +
                "_ _ O _ _ X _ _ \n" +
                "_ O _ _ _ _ X _ \n" +
                "O _ _ _ _ _ _ X\n" +
                "  b\n");

        System.out.println("_ _ X X O O _ _ \n" +
                "_ _ X X O O _ _ \n" +
                "_ _ X X O O _ _ \n" +
                "_ _ X X O O _ _ \n" +
                "_ _ X X O O _ _ \n" +
                "_ _ X X O O _ _ \n" +
                "_ _ X X O O _ _ \n" +
                "_ _ X X O O _ _\n" +
                "  c\n");

        System.out.println("Choose a board type: ");

        String in = stdin.readLine();
        int[][] board = new int[8][8];
        int empty = 1;

        //0 is empty        1 is black      -1 is white
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j]= 0;
            }
        }

        if(in.charAt(0)=='a'){
            board[3][4]= 1;
            board[4][3]= 1;
            board[3][3] =-1;
            board[4][4] = -1;
        }
        else if(in.charAt(0)=='b'){
            for(int i =0; i<board.length; i++){
                board[i][i]=1;
                board[7-i][i]=-1;
            }
        }
        else{
            for(int i=0; i<board.length; i++){
                board[i][2]= 1;
                board[i][3]= 1;
                board[i][4] = -1;
                board[i][5] = -1;
            }
        }

        outBoard(board, empty);

        int white =0;
        int black =0;
        int turn =1;
        int antiturn=-1;

        while(empty>0){
            System.out.print("Input the x value of " + turn(turn) + " turn: ");
            int x = Integer.parseInt(stdin.readLine())-1;
            System.out.print("Input the y value of " + turn(turn) + " turn: ");
            int y =  Integer.parseInt(stdin.readLine())-1;

            boolean flipped=false;

            if(board[y][x]==0 || board[y][x]==2){
                board[y][x] = turn;

                for(int z=-1; z<2; z++){
                    for(int m=-1; m<2; m++){
                        if(!(m==0 && z==0) && flip(board, x, y, m, z)){
                            flipped=true;
                        }
                    }
                }
            }

            if(flipped){
                turn*=-1;
                antiturn*=-1;
                outBoard(board, empty);
            }
            else{
                System.out.println("Invalid input! Please try again\n");
            }

        }

        countPieces(board);

    }
}



