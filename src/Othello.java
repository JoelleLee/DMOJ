import java.io.*;

public class Othello {
    public static int outBoard(int[][] board){

        int empty=0;

        System.out.println("  1 2 3 4 5 6 7 8 ");
        for(int z=0; z<8; z++){
            System.out.print((z+1)+" ");
            for(int l=0; l<8; l++){
                if(board[z][l]==0){
                    System.out.print("_ ");
                    empty++;
                }
                else if(board[z][l]==1){
                    System.out.print("X ");
                }
                else if(board[z][l]==3){
                    System.out.print("* ");
                    empty++;
                }
                else{
                    System.out.print("O ");
                }
            }
            System.out.println("");
        }
        System.out.println("");

        return empty;

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
    public static boolean flip(int[][] board, int x, int y, int m, int z, int turn){

        y+=z;
        x+=m;
        int count=0;

        while(x>=0 && y>=0 && x<=7 && y<=7 && board[y][x]==-1*turn){
            y+=z;
            x+=m;
            count++;
        }

        if(y<=7 && y>=0 && x<=7 && x>=0 && board[y][x]==turn && count>0){
            while(board[y-z][x-m]==-1*turn){
                board[y-z][x-m]=turn;
                y-=z;
                x-=m;
            }
            return true;
        }

        return false;
    }
    public static boolean checkFlip(int[][] board, int turn, int x, int y){

        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){
                int a=x+i;
                int b=y+j;
                int count =0;

                while(a>=0 && a<=7 && b>=0 && b<=7 && board[b][a]==-1*turn){
                    b+=j;
                    a+=i;
                    count++;
                }

                if(a>=0 && a<=7 && b>=0 && b<=7 && board[b][a]==turn && count>0){
                    return true;
                }
            }
        }
        return false;
    }
    public static void hint(int[][] board, int turn){

        int[][] hintDisplay= new int[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                hintDisplay[j][i]= board[j][i];
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[j][i]==0){
                    boolean hints = checkFlip(board, turn, i, j);

                    if(hints){
                        hintDisplay[j][i] = 3;
                    }
                }
            }
            System.out.println("");
        }

        int empty=outBoard(hintDisplay);

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

        System.out.print("Choose a board type (a/b/c): ");

        String in = stdin.readLine();

        int[][] board = new int[8][8];
        int empty = 1;

        //0 is empty        1 is black      -1 is white     3 is hint star
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
                board[board.length-1-i][i]=-1;
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

        empty = outBoard(board);

        int white =0;
        int black =0;
        int turn =1;

        while(empty>0){
            System.out.print("Input the position of " + turn(turn) + " turn (input format \"column row\"): ");
            String[] input = stdin.readLine().split(" ");
            int x = Integer.parseInt(input[0])-1;
            int y =  Integer.parseInt(input[1])-1;

            boolean flipped=false;

            if(board[y][x]==0){
                for(int z=-1; z<2; z++){
                    for(int m=-1; m<2; m++){
                        if(!(m==0 && z==0) && flip(board, x, y, m, z, turn)){
                            flipped=true;
                        }
                    }
                }
            }

            if(flipped){
                board[y][x] = turn;
                turn*=-1;
                empty = outBoard(board);
            }
            else{
                System.out.println("Invalid input! Please try again\n");
                System.out.println("If you would like a hint, enter 911, else enter 0");
                int wantHint = Integer.parseInt(stdin.readLine());

                if(wantHint==911){
                    hint(board, turn);
                }

            }

        }

        countPieces(board);

    }
}
