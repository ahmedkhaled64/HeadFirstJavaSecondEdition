package ch6.dotComBust;

import ch6.dotComBust.entities.DotCom;
import ch6.dotComBust.entities.GameHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DotComBust {
    private static final int NUMBERS_OF_DOT_COMS = 3;
    private static final int LENGTH_OF_DOT_COM = 3;
    private static final List<String> DOT_COM_NAMES = new ArrayList<>(Arrays.asList("Pets.com", "eToys.com", "Go2.com"));
    GameHelper helper = new GameHelper();
    ArrayList<DotCom> dotComs = new ArrayList<>();
    int numOfGuesses = 0;

    private void setUpGame() {
        createDotComSamples();
        printInstructions();
        updateLocationOfEachSample();
    }

    private void updateLocationOfEachSample() {
        for (DotCom dotCom : dotComs) {
            List<String> newLocation = helper.PlaceDotComRandomly(LENGTH_OF_DOT_COM);
            dotCom.setLocationCells(newLocation);
        }
    }

    private static void printInstructions() {
        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");
    }

    private void createDotComSamples() {
        for (int i = 0; i < NUMBERS_OF_DOT_COMS; i++) {
            DotCom dotCom = new DotCom();
            dotCom.setName(DOT_COM_NAMES.get(i));
            dotComs.add(dotCom);
        }
    }

    private void startPlaying() {
        while (!dotComs.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        String result = "Miss";
        numOfGuesses++;
        for (DotCom dotCom : dotComs) {
            result = dotCom.checkYourSelf(userGuess);
            if (result.equalsIgnoreCase("Kill")) {
                dotComs.remove(dotCom);
                break;
            }
            if (result.equalsIgnoreCase("Hit"))
                break;
        }
        System.out.println("result: " + result);
    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println(" You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }

    public static void main(String[] args) {
        DotComBust dotComBust = new DotComBust();
        dotComBust.setUpGame();
        dotComBust.startPlaying();
    }


}
