package ch6.dotComBust.entities;

import java.util.ArrayList;
import java.util.List;

public class DotCom {
    private String name;
    private List<String> locationCells;

    public DotCom() {
        locationCells = new ArrayList<>();
    }

    public String checkYourSelf(String guess) {
        String result = "Miss";
        int index = locationCells.indexOf(guess);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Kill";
                System.out.println("Ouch! You sunk " + name + " : ( ");
            }
            else
                result = "Hit";
        }
        return result;
    }

    public void setLocationCells(List<String> locationCells) {
        this.locationCells = locationCells;
    }

    public void setName(String name) {
        this.name = name;
    }

}
