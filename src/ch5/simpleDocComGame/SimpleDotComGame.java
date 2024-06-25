package ch5.simpleDocComGame;

import ch5.simpleDocComGame.entities.DefaultSimpleDotCom;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleDotComGame {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        DefaultSimpleDotCom dot = new DefaultSimpleDotCom();
        boolean isAlive = true;
        int numberOfUserGuesses = 0;
        dot.setLocationCells(createRandomLocationCells());
        while (isAlive) {
            String userGuess = getUserGuess();
            String result = dot.checkYourSelf(userGuess);
            numberOfUserGuesses++;
            if (result.equalsIgnoreCase("kill")) {
                isAlive = false;
                System.out.println("Number of user guesses: " + numberOfUserGuesses);
            }
        }
    }

    private static String getUserGuess() {
        System.out.print("Enter a number: ");
        return scanner.next();
    }

    private static ArrayList<String> createRandomLocationCells() {
        int randomNum = (int) (Math.random() * 5);
        ArrayList<String> locations = new ArrayList<>();
        locations.add(String.valueOf(randomNum));
        locations.add(String.valueOf(randomNum + 1));
        locations.add(String.valueOf(randomNum + 2));
        return locations;
    }

}
