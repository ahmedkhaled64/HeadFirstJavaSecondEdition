package ch5.simpleDocComGame.tests;

import ch5.simpleDocComGame.entities.DefaultSimpleDotCom;

import java.util.ArrayList;
import java.util.Arrays;

public class TestDefaultSimpleDotCom {
    public static void main(String[] args) {
        startTest();
    }

    private static void startTest() {
        DefaultSimpleDotCom simpleDotCom = new DefaultSimpleDotCom();
        ArrayList<String> locations = new ArrayList<>(Arrays.asList("2", "3", "4"));
        simpleDotCom.setLocationCells(locations);
        String userGuess = "2";
        String testResult = "failed";
        String result = simpleDotCom.checkYourSelf(userGuess);
        if(result.equalsIgnoreCase("hit"))
            testResult = "passed";
        System.out.println(testResult);
    }
}
