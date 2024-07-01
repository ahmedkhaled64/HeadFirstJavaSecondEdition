package ch6.dotComBust.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameHelper {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ALPHABET = "abcdefg";
    private static final int GRID_LENGTH = 7;
    private static final int GRID_SIZE = 49;
    private final int[] grid = new int[GRID_SIZE];
    private int comCount = 0;

    public List<String> PlaceDotComRandomly(int comSize) {
        comCount++;
        int[] coords = generateRandomCoordsLocations(comSize);
        return transformCoordsLocationsToAlphaCoords(coords);
    }

    private int[] generateRandomCoordsLocations(int comSize) {
        int[] coords = new int[comSize];
        int numOfTries = 0;
        boolean success = false;
        int increment = placeDotComVerticalIfOdd();
        while (!success & numOfTries++ < 200) {
            int location = (int) (Math.random() * GRID_SIZE);
            int nPositionInDotComToPlace = 0;
            success = true;
            while (success && nPositionInDotComToPlace < comSize) {
                if (isLocationNotUsedPreviously(location)) {
                    coords[nPositionInDotComToPlace++] = location;
                    location += increment;
                    if (isLastLocationOnBottom(location))
                        success = false;
                    if (isLastLocationOnRightEdge(nPositionInDotComToPlace, location))
                        success = false;
                } else {
                    success = false;
                }
            }
        } 
        return coords;
    }

    private List<String> transformCoordsLocationsToAlphaCoords(int[] coords) {
        List<String> alphaCells = new ArrayList<>();
        for (int coord : coords) {
            String temp;
            grid[coord] = 1;
            int row = coord / GRID_LENGTH;
            int column = coord % GRID_LENGTH;
            temp = String.valueOf(ALPHABET.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(row)));
        }
        return alphaCells;
    }

    private static boolean isLastLocationOnBottom(int location) {
        return location >= GRID_SIZE;
    }

    private static boolean isLastLocationOnRightEdge(int nPositionInDotComToPlace, int location) {
        return nPositionInDotComToPlace > 0 && (location % GRID_LENGTH == 0);
    }

    private int placeDotComVerticalIfOdd() {
        return (comCount % 2) == 1 ? GRID_LENGTH : 1;
    }

    private boolean isLocationNotUsedPreviously(int location) {
        return grid[location] == 0;
    }

    public String getUserInput(String userMessage) {
        System.out.print(userMessage);
        return scanner.next();
    }
}
