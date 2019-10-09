import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Random;

public class RunFullExpirament {



    /* define constants */

    static int MAXVALUE =  2000000000;

    static int MINVALUE = -2000000000;

    static int numberOfTrials = 100;

    static int MAXINPUTSIZE  = (int) Math.pow(2,14);

    static int MININPUTSIZE  =  1;

    // static int SIZEINCREMENT =  10000000; // not using this since we are doubling the size each time



    static String ResultsFolderPath = "/home/wyatt/Results/lab4/"; // pathname to results folder

    static FileWriter resultsFile;

    static PrintWriter resultsWriter;

    //function to run full experiment
    static void runFullExperiment(String resultsFileName, String whichSort){


        //trying to write to file and displaying error message if it fails
        try {

            resultsFile = new FileWriter(ResultsFolderPath + resultsFileName);

            resultsWriter = new PrintWriter(resultsFile);

        } catch(Exception e) {

            System.out.println("*****!!!!!  Had a problem opening the results file "+ResultsFolderPath+resultsFileName);

            return; // not very foolproof... but we do expect to be able to create/open the file...

        }


        // instantiating stopwatch class
        ThreadCpuStopWatch BatchStopwatch = new ThreadCpuStopWatch(); // for timing an entire set of trials

        ThreadCpuStopWatch TrialStopwatch = new ThreadCpuStopWatch(); // for timing an individual trial


        //printing to file
        resultsWriter.println("#InputSize    AverageTime"); // # marks a comment in gnuplot data
        //flushing so it immediately goes to file and not a queue
        resultsWriter.flush();

        /* for each size of input we want to test: in this case starting small and doubling the size each time */

        for(int inputSize=MININPUTSIZE;inputSize<=MAXINPUTSIZE; inputSize*=2) {

            // progress message...

            System.out.println("Running test for input size "+inputSize+" ... ");




            long batchElapsedTime = 0;


            //forcing garbage collection
            System.gc();



            // run the trials

            for (int trial = 0; trial < numberOfTrials; trial++) {

                long[] testList = createRandomIntegerList(inputSize);
                //Sorts.mergeSortWrapper(testList);
                /* run the function we're testing on the trial input */

                if("bubbleSort".equals(whichSort))
                {
                    //System.out.println("success bubble");
                    TrialStopwatch.start();
                    Sorts.bubbleSort(testList);
                    batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();
                }
                else if ("insertionSort".equals(whichSort))
                {
                    TrialStopwatch.start();
                    Sorts.insertionSort(testList);
                    batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();
                }
                else if ("mergeSort".equals(whichSort))
                {
                    //System.out.println("success merge");
                    TrialStopwatch.start();
                    Sorts.mergeSortWrapper(testList);
                    batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();
                }
                else if ("quickSort".equals(whichSort))
                {
                    //System.out.println("success quick");
                    TrialStopwatch.start();
                    Sorts.quickSortWrapper(testList);
                    batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();
                }
                else if("quickSortFaster".equals(whichSort))
                {
                    //System.out.println("success quick sort faster ");
                    TrialStopwatch.start();
                    Sorts.quickSortFasterWrapper(testList);
                    batchElapsedTime = batchElapsedTime + TrialStopwatch.elapsedTime();
                }
                else
                {
                    System.out.println("that was not a valid input");
                    System.out.println("valid inputs are:");
                    System.out.println("bubbleSort\ninsertionSort\nmergeSort\nquickSort\nquickSortFaster");
                    System.exit(0);
                }


            }

            // calculate the average time per trial in this batch
            double averageTimePerTrialInBatch = (double) batchElapsedTime / (double)numberOfTrials;



            /* print data for this size of input */

            resultsWriter.printf("%12d  %15.2f \n",inputSize, averageTimePerTrialInBatch);
            //using flush so it immediately writes to file and does not go to queue
            resultsWriter.flush();

            System.out.println(" ....done.");

        }

    }

    static long[] createRandomIntegerList(int inputSize)
    {
        Random random = new Random();

        long[] array = new long[inputSize];

        for(int i = 0; i < inputSize; i++)
        {
            array[i] = random.nextLong();
        }

        return array;
    }


}
