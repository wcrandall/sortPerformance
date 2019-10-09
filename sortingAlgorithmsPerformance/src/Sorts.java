import java.util.Random;

public class Sorts {

    /* return index of the searched number if found, or -1 if not found */

    static void merge(long arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        long L[] = new long [n1];
        long R[] = new long [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(long arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }













    static void bubbleSort(long[] arrayToSort)
    {
        for(int i = 0; i < arrayToSort.length-1; i++)
        {
            for(int j = 0; j < arrayToSort.length-i-1; j++)
            {
                if(arrayToSort[j] > arrayToSort[j+1])
                {
                    long temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j+1];
                    arrayToSort[j+1] = temp;
                }
            }
        }
    }

    static void insertionSort(long arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            long key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }





    /* This function takes last element as pivot,
   places the pivot element at its correct
   position in sorted array, and places all
   smaller (smaller than pivot) to left of
   pivot and all greater elements to right
   of pivot */
    static int partition(long arr[], int low, int high)
    {
        long pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        long temp = arr[(i+1)];
        arr[i+1] = arr[(int)high];
        arr[(int)high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void quickSort(long arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }


    public static void quickSortFaster(long[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivot = randomizedPartition(array,startIndex,endIndex);
            quickSortFaster(array,startIndex,pivot - 1);
            quickSortFaster(array,pivot + 1,endIndex);
        }
    }

    public static int randomizedPartition(long[] array, int startIndex, int endIndex) {
        int randomEndIndex = randomNumberBetween(startIndex,endIndex);
        swapFaster(array,endIndex,randomEndIndex);
        return partitionFaster(array,startIndex,endIndex);
    }

    public static int randomNumberBetween(int startNumber, int endNumber) {
        return (int)Math.floor(Math.random() * (endNumber - startNumber + 1) + startNumber);
    }

    public static int partitionFaster(long[] array,int startIndex,int endIndex) {
        long pivotValue = array[endIndex];
        int pivotIndex = startIndex;

        for (int j = startIndex; j < endIndex; j++) {
            if (array[j] <= pivotValue) {
                swapFaster(array,pivotIndex,j);
                pivotIndex = pivotIndex + 1;
            }
        }
        swapFaster(array,pivotIndex,endIndex);
        return pivotIndex;
    }

    public static void swapFaster(long[] array, int firstIndex, int secondIndex) {
        long temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    static void quickSortFasterWrapper(long arr[])
    {
        quickSortFaster(arr,0,arr.length-1);
    }
    static void quickSortWrapper(long arr[])
    {
        quickSort(arr, 0, arr.length-1);
    }

    static void mergeSortWrapper(long arr[])
    {
        mergeSort(arr, 0, arr.length-1);
    }
}
