package ch5;

import java.util.Scanner;

public class SimpleDotComGame {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DefaultSimpleDotCom dot = new DefaultSimpleDotCom();
        boolean isAlive = true;
        int numberOfUserGuesses = 0;
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        dot.setLocationCells(locations);
        while (isAlive) {
            System.out.print("Enter a number: ");
            String userGuess = scanner.next();
            String result = dot.checkYourSelf(userGuess);
            numberOfUserGuesses++;
            if (result.equalsIgnoreCase("kill")) {
                isAlive = false;
                System.out.println("Number of user guesses: " + numberOfUserGuesses);
            }

        }
    }

}
