package com.ust;
import  java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    static void main() {
        int upperbound = 5;

        Random random = new Random();
        int secretNumber = random.nextInt(upperbound)+1;

        int maxAttempt = 3;
        System.out.println("Number Guessing Game");
        System.out.println("You have "+maxAttempt+" attempts. ");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        boolean won = false;

        for(int i=0; i< maxAttempt;i++){
            System.out.print("Guess the Number between 1 and "+upperbound+" :");
            int guess = sc.nextInt();
            won = (guess == secretNumber);

            if(won){
                System.out.println("Success! You have guessed Correctly");
                break;
            }
            else{
                System.out.println("Sorry! Your guess is incorrect");
                System.out.println("You have "+(maxAttempt-1-i)+" attempts left.");
                System.out.println();
            }


        }
        sc.close();

        if(!won){
            System.out.println("You did not win. The Secret number was: "+secretNumber);
        }




    }
}
