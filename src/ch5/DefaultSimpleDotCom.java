package ch5;

public class DefaultSimpleDotCom implements SimpleDotCom {
    private int [] locationCells;
    private int numbersOfHit;

    public DefaultSimpleDotCom() {
        locationCells = new int[3];
        numbersOfHit = 0;
    }

    @Override
    public String checkYourSelf(String guess) {
        int guessInt = Integer.parseInt(guess);
        String result = "Miss";
        for (int cell : locationCells) {
            if (guessInt == cell) {
                numbersOfHit++;
                result = "Hit";
                break;
            }
        }
        if (numbersOfHit == 3)
            result = "Kill";
        System.out.println(result);
        return result;
    }

    @Override
    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }
}
