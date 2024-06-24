package ch5;

public class TestDefaultSimpleDotCom {
    public static void main(String[] args) {
        // Test checkYourSelf method
        DefaultSimpleDotCom simpleDotCom = new DefaultSimpleDotCom();
        int[] locations = {2, 3, 4};
        simpleDotCom.setLocationCells(locations);
        String userGuess = "2";
        String testResult = "failed";
        String result = simpleDotCom.checkYourSelf(userGuess);

        if(result.equalsIgnoreCase("hit"))
            testResult = "passed";
        System.out.println(testResult);
    }
}
