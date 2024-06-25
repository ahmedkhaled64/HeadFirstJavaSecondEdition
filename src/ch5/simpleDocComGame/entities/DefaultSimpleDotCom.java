package ch5.simpleDocComGame.entities;

import java.util.ArrayList;

public class DefaultSimpleDotCom implements SimpleDotCom {
    private ArrayList<String> locationCells;

    public DefaultSimpleDotCom() {
        locationCells = new ArrayList<>();
    }

    @Override
    public String checkYourSelf(String guess) {
        String result = "Miss";
        int index = locationCells.indexOf(guess);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty())
                result = "Kill";
            else
                result = "Hit";
        }
        System.out.println(result);
        return result;
    }

    @Override
    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }
}
