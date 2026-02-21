package com.ust;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGuessing {

//    private static String getRandomWord() {
//        String[] words = {"Java", "Airplane", "Friend"};
//        Random random = new Random();
//        int index = random.nextInt(words.length) ;
//        String theWord = words[index];
//        return theWord.toUpperCase () ;
//    }

    private static String getRandomWord(String filename) {

        try {
            List<String> lineList = Files.readAllLines(Path.of(filename));
            String []words = lineList.toArray(new String[0]);
            Random random = new Random();
            int index = random.nextInt(words.length) ;
            String theWord = words[index];
            return theWord.toUpperCase () ;
        }
        catch (Exception e){
            System.out.println(e);
        }
       return "";

    }
    private static boolean containsUnderscore(char[] gameBoard){
        for(char ch: gameBoard){
            if(ch == '_'){
                return true;
            }
        }
        return false;
    }
    static void main() {

        String secretWord = getRandomWord("/Users/shanjaygovindaraj/UST_Training/UST_PROJECT_TRAINING/JAVA_LEARNING/src/main/java/com/ust/data/sample-text.txt");
        int maxAttempts = 10;
        char[] gameBoard = new char[secretWord.length()];
        boolean hasMissingLetters = true;

//        for(int i=0;i<secretWord.length();i++){
//            gameboard[i] = '_';
//        }

        Arrays.fill(gameBoard, '_');

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Word Quest");
        while(maxAttempts>0 && hasMissingLetters){
            System.out.print("Current Word: ");
            System.out.println(gameBoard);
            System.out.println();

            System.out.println("Guess a letter: ");
            char guesschar = sc.next().toUpperCase().charAt(0);


            boolean isGuessCorrect = false;
            for(int i=0;i<secretWord.length();i++){
                if(secretWord.charAt(i) == guesschar){
                    gameBoard[i] = guesschar;
                    isGuessCorrect = true;
                }
            }

            if(isGuessCorrect){
                System.out.println("Good Job! You have found a match");
                hasMissingLetters = containsUnderscore(gameBoard);
            }
            else{
                System.out.println("Incorrect! Try Again");
                maxAttempts--;
            }

            System.out.println("You have "+maxAttempts+ " Attempts.");
            System.out.println();

        }
        if(!hasMissingLetters){
            System.out.println("Congrats! You Found the word: "+secretWord);
            System.out.println();
        }
        else{
            System.out.println("Sorry! You Lost");
            System.out.println("The Secret Word: "+ secretWord);
            System.out.println();
        }
    }
}
