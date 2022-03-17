import java.io.*;
import java.util.Random;

public class NumberGuessing {
    public static void main(String args[]) throws IOException{

        DataInputStream stdin = new DataInputStream(System.in);

        Random RandNumber = new Random();
        int answer;

        answer = 1 + RandNumber.nextInt(100);

        int guess = 0;
        int low = 0;
        int high = 100;

        System.out.println("Guess a number between " + low + " and "+ high );
        guess = Integer.parseInt(stdin.readLine());

        while(guess > high || guess < low){
            System.out.println("ERROR!");

            System.out.println("Guess a number between " + low + " and "+ high );
            guess = Integer.parseInt(stdin.readLine());
        }

        while(guess != answer){


            if(answer > guess){
                System.out.println(guess + " is smaller than answer.");
                low = guess;
            }
            else if(answer < guess){
                System.out.println(guess + " is greater than answer");
                high = guess;
            }

            System.out.println("Guess a number between " + low + " and "+ high );
            guess = Integer.parseInt(stdin.readLine());

            while(guess > high || guess < low){
                System.out.println("ERROR!");

                System.out.println("Guess a number between " + low + " and "+ high );
                guess = Integer.parseInt(stdin.readLine());
            }

        }


        System.out.print("You won! " + guess + " is the right answer");


    }
}
