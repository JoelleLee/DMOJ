import java.io.*;

public class WorkHours {
    public static void main(String[] args) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int hours[]= new int[7];
        int worked = 0;
        int extra = 0;

        int most = 0;
        int least = 0;

        for(int i =0; i<7; i++){

            System.out.println("How many hours did you work on " + week[i]);
            hours[i] = Integer.parseInt(stdin.readLine());

            if(i==0 || hours[i]<hours[least]){
                least = i;
            }

            if(hours[i]>hours[most]){
                most = i;
            }

            if(hours[i]>8){
                extra += hours[i]-8;
                worked += 8;
            }
            else{
                worked += hours[i];
            }
        }
        System.out.println("You worked least on " + week[least] + " for " + hours[least] + " and worked the most on " + week[most] + " for " + hours[most]);

        System.out.println("wage: ");
        int wage = Integer.parseInt(stdin.readLine());
        System.out.println("You made $" + (worked+extra*1.5)*wage);

    }
}
