package ch5;

public class DefaultSimpleDotCom implements SimpleDotCom {
    private int [] locationCells;
    private int numbersOfHit;

    public DefaultSimpleDotCom(){
        locationCells = new int [3];
        numbersOfHit = 0;
    }

    @Override
    public String checkYourSelf(String guess) {
        int guessInt = Integer.parseInt(guess);
        for (int cell : locationCells) {
            if (guessInt == cell) {
                numbersOfHit++;
                if (numbersOfHit == 3) {
                    return "Kill";
                }else {
                    return "Hit";
                }
            } else {
                return "Miss";
            }
        }
        return null;
    }

    @Override
    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }
}
