import java.io.*;

public class PlaylistOrder {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        System.out.print("Press Button (1/2/3/4)");
        int button = Integer.parseInt(stdin.readLine());

        System.out.print("n: ");
        int n = Integer.parseInt(stdin.readLine());

        String playlist = "A B C D E ";

        while(button != 4){

            for(int i = 1; i <= n; i++){

                if(button == 1){
                    playlist = playlist.substring(0, 2) + playlist.substring(2);
                }
                else if(button == 2){
                    playlist = playlist.substring(8) + playlist.substring(0, 8);
                }
                else if(button == 3){
                    playlist = playlist.substring(2, 4) + playlist.substring(0, 2) + playlist.substring(4);
                }

            }


            System.out.print("Press Button (1/2/3/4)");
            button = Integer.parseInt(stdin.readLine());

            System.out.print("n: ");
            n = Integer.parseInt(stdin.readLine());

        }

        System.out.print(playlist);





    }
}
