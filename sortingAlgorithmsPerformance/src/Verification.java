public class Verification {

    static void checkSortCorrectness(int lengthOfArray)
    {
        System.out.println("bubblesort with array of length " + lengthOfArray);
        boolean check = verificationOfBubbleSort(lengthOfArray);
        if(check)
        {
            System.out.println("bubbleSort successful");
        }
        else{
            System.out.println("bubbleSort was unsuccessful");
        }

        System.out.println("insertionSort with array of length " + lengthOfArray);
        check = verificationOfInsertionSort(lengthOfArray);
        if(check)
        {
            System.out.println("insertionSort successful");
        }
        else{
            System.out.println("insertionSort was unsuccessful");
        }


        System.out.println("mergeSort with array of length " + lengthOfArray);
        check = verificationOfMergeSort(lengthOfArray);
        if(check)
        {
            System.out.println("mergeSort successful");
        }
        else{
            System.out.println("mergeSort was unsuccessful");
        }

        System.out.println("quickSort with array of length " + lengthOfArray);
        check = verificationOfQuickSort(lengthOfArray);
        if(check)
        {
            System.out.println("quickSort Successful");
        }
        else{
            System.out.println("quickSort was unsuccessful");
        }

        System.out.println("quickSortFaster with array of length " + lengthOfArray);
        check = verificationOfQuickSortFaster(lengthOfArray);
        if(check)
        {
            System.out.println("quickSortFaster Successful");
        }
        else{
            System.out.println("quickSortFaster was unsuccessful");
        }
        
        //verificationOfQuickSortNaive(lengthOfArray);
    }

    static boolean verifySorted(long[] array)
    {

        if(array == null)
        {
            System.out.println("your array is null");
            return false;
        }
        
        if(array.length == 1 || array.length == 0)
        {
            return true; 
        }
        
        for(int i = 0; i < array.length-1; i++)
        {
            if(array[i] > array[i+1])
            {
                return false;
            }
        }

        return true;
    }

    static boolean verificationOfBubbleSort(int lengthOfArray)
    {
        long array[] = RunFullExpirament.createRandomIntegerList(lengthOfArray);
        if (lengthOfArray < 20) {
            System.out.println("before sorted");
            printArray(array);
            Sorts.bubbleSort(array);
            System.out.println("after sorted");
            printArray(array);
        }
        else
        {
            Sorts.bubbleSort(array);
        }
        return verifySorted(array);
    }
    static boolean verificationOfInsertionSort(int lengthOfArray)
    {
        long array[] = RunFullExpirament.createRandomIntegerList(lengthOfArray);
        if (lengthOfArray < 20) {
            System.out.println("before sorted");
            printArray(array);
            Sorts.insertionSort(array);
            System.out.println("after sorted");
            printArray(array);
        }
        else
        {
            Sorts.insertionSort(array);
        }
        return verifySorted(array);
    }

    static boolean verificationOfMergeSort(int lengthOfArray)
    {
        long array[] = RunFullExpirament.createRandomIntegerList(lengthOfArray);
        if(lengthOfArray < 20) {
            System.out.println("before sorted");
            printArray(array);
            Sorts.mergeSortWrapper(array);
            System.out.println("after sorted");
            printArray(array);
        }
        else{
            Sorts.mergeSortWrapper(array);
        }
        return verifySorted(array);
    }

    static boolean verificationOfQuickSort(int lengthOfArray)
    {
        long array[] = RunFullExpirament.createRandomIntegerList(lengthOfArray);

        if(lengthOfArray < 20) {

            System.out.println("before sorted");
            printArray(array);
            Sorts.quickSortWrapper(array);
            System.out.println("after sorted");
            printArray(array);
        }
        else{
            Sorts.quickSortWrapper(array);
        }
        return verifySorted(array); 
    }

    static boolean verificationOfQuickSortFaster(int lengthOfArray)
    {
        long array[] = RunFullExpirament.createRandomIntegerList(lengthOfArray);

        if(lengthOfArray < 20) {

            System.out.println("before sorted");
            printArray(array);
            Sorts.quickSortFasterWrapper(array);
            System.out.println("after sorted");
            printArray(array);
        }
        else{
            Sorts.quickSortFasterWrapper(array);
        }
        return verifySorted(array);
    }


//    verificationOfQuickSortNaive(int lengthOfArray)
//    {
//        long array[] = RunFullExpirament.createRandomIntegerList(lengthOfArray);
//
//        printArray(array);
//        Sorts.quickSortNaive(array, 0, array.length-1);
//        printArray(array);
//    }



    static void printArray(long[] array)
    {
        int length = array.length;

        for(int i = 0; i < length; i++)
        {
            System.out.println(array[i]);
        }
    }
}

