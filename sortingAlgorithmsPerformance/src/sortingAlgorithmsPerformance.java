import java.util.Scanner;

public class sortingAlgorithmsPerformance {
    public static void main(String args[])
    {

        //Verification.checkSortCorrectness(5000);
        //System.exit(0);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter what sort you want to test: ");
        String nameOfSortToTest = scanner.next();

        

        int timesToRunFull = 3;

        for(int i = 0; i < timesToRunFull; i++)
        {
            RunFullExpirament.runFullExperiment(nameOfSortToTest + "exp" + i + ".txt", nameOfSortToTest);
        }

    }




}
