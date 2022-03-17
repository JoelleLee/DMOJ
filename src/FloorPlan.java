import java.io.*;

public class FloorPlan {
    public static int roomSize(int size, int x, int y, int[][] plan){

        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){
                if(x+i<plan.length && x+i>=0 && y+j<plan[0].length && y+j>=0 && plan[x+i][y+j]==-1){
                    plan[x+i][y+j] = 0;
                    size = roomSize(size+1, x+i, y+j, plan);
                }
            }
        }

        return size;
    }
    {
        //public static int roomSize(int size, int x, int y, int[][] plan){
        //
        //        if(x<0 || y<0 || x>=plan.length || y>=plan[0].length || plan[x][y]!=0) {
        //            return size;
        //        }
        //
        //        plan[x][y]=8;
        //        size++;
        //
        //        System.out.println("l");
        //        size = roomSize(size, x, y-1, plan);
        //        System.out.println("u");
        //        size = roomSize(size, x-1, y, plan);
        //        System.out.println("r");
        //        size = roomSize(size, x, y+1, plan);
        //        System.out.println("d");
        //        size = roomSize(size, x+1, y, plan);
        //
        //        return size;
        //    }
    }
    public static void main(String[] args) throws IOException{
        DataInputStream stdin = new DataInputStream(System.in);

        int flooring = Integer.parseInt(stdin.readLine());
        int[][] plan = new int[Integer.parseInt(stdin.readLine())][Integer.parseInt(stdin.readLine())];

        //make walls 0 and floor -1
        for(int i=0; i<plan.length; i++){
            String[] input = stdin.readLine().split("");
            for(int j=0; j<plan[0].length; j++){//charAt
                if(input[j].equals("I")){
                    plan[i][j] = 0;
                }
                else{
                    plan[i][j] = -1;
                }
            }
        }

        //find rooms
        String room ="";
        for(int i=0; i<plan.length; i++){
            for(int j=0; j<plan[0].length; j++){
                if(plan[i][j]==-1){
                    plan[i][j] = 0;
                    room+=roomSize(1, i, j, plan)+" ";
                    {
                        System.out.println(room);

                        for(int t=0; t<plan.length; t++){
                            for(int p=0; p<plan[0].length; p++){
                                System.out.print(plan[t][p]+" ");
                            }
                            System.out.println("");
                        }
                        System.out.println("");
                    }
                }
            }
        }

        String[] rooms = room.split(" ");
        int roomsCovered = 0;
        int[] roomsSize = new int[rooms.length];

        for(int i=0; i<roomsSize.length; i++){
            roomsSize[i] = Integer.parseInt(rooms[i]);
        }

        for(int i=1; i<roomsSize.length; i++){
            int hold = roomsSize[i];
            int j=i-1;
            while(j>=0 && roomsSize[j]<hold){
                roomsSize[j+1] = roomsSize[j];
                j--;
            }

            roomsSize[j+1]=hold;
        }

        while(roomsCovered<roomsSize.length && flooring-roomsSize[roomsCovered]>=0){
            flooring-=roomsSize[roomsCovered];
            roomsCovered++;
        }
        System.out.println(roomsCovered+ " rooms, "+ flooring + " square metre(s) left over");

    }
}
