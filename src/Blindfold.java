import java.io.*;

public class Blindfold {
    //1 north, 2 east, 3 south, 4 west
    public static void positionFinal(char[][] backyard, String moves, int direction, int row, int col){

        if (row<0 || col<0 || row>=backyard.length || col>=backyard[0].length || backyard[row][col]=='X') {
            return;
        }

        if(moves.equals("")){
            backyard[row][col]='*';
            return;
        }

        if(moves.charAt(0)=='L') {
            direction=(direction+3)%4;
        }
        else if(moves.charAt(0)=='R'){
            direction= (direction+1)%4;
        }
        else if(moves.charAt(0)=='F'){
            if(direction==1){
                row--;
            }
            else if(direction==2){
                col++;
            }
            else if(direction==3){
                row++;
            }
            else{
                col--;
            }
        }

        positionFinal(backyard, moves.substring(1), direction, row, col);
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int row = Integer.parseInt(stdin.readLine());
        int col = Integer.parseInt(stdin.readLine());
        char[][] backyard = new char[row][col];

        for(int i=0; i<row; i++){
            String input = stdin.readLine();
            for(int j=0; j<col; j++){
                backyard[i][j]=input.charAt(j);
            }
        }

        int moveNum = Integer.parseInt(stdin.readLine());
        String moves = "";

        for(int i=0; i<moveNum; i++){
            moves+=stdin.readLine();
        }

        for ( int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for(int k = 1; k<=4; k++){
                    positionFinal(backyard, moves, k, i, j);
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(backyard[i][j]);
            }
            System.out.println("");
        }

    }
}
