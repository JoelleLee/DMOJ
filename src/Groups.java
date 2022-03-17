import java.io.*;

public class Groups {
    public static int identity(int[][] group){
        for(int i=0; i<group.length; i++){
            int j=0;
            while(j<group.length && group[i][j]==j+1 && group[j][i]==j+1){
                j++;
            }

            if(j==group.length){
                return i+1;
            }
        }
        return -1;
    }
    public static boolean inverse(int[][] group, int id){
        for(int i=0; i<group.length; i++) {
            boolean check=false;
            for(int j=0; j<group.length; j++){
                if(group[i][j]==id){
                    if(group[j][i]==id){
                        check=true;
                    }
                    else{
                        return false;
                    }
                }
            }
            if(!check){
                return false;
            }
        }
        return true;
    }
    public static boolean associate(int[][] group){

        for(int i=0; i<group.length; i++){
            for(int j=0; j<group.length; j++){
                for(int z=0; z<group.length; z++){
                    if(group[group[i][j]-1][z]!=group[i][group[j][z]-1]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        int input = Integer.parseInt(stdin.readLine());
        String output = "";

        while(input!=0){
            int[][] group = new int[input][input];
            boolean isG = true;

            for(int i=0; i<input; i++){
                String[] in = stdin.readLine().split(" ");
                for(int j=0; j<input; j++){
                    group[i][j] = Integer.parseInt(in[j]);
                    if (group[i][j] > input || group[i][j] < 1) {//checking if aXb is in group
                        isG= false;
                    }
                }
            }

            int id = identity(group);

            if(isG && id>=0 && inverse(group, id) && associate(group)){//dont check all at once... idG first etc and if false immediate output
                output+="Yes \n";
            }
            else{
                output+="No \n";
            }

            input = Integer.parseInt(stdin.readLine());
        }

        System.out.println(output);
    }
}
