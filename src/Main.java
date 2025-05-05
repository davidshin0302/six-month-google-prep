import searchAlgorithm.BinarySearch;
import sortAlgorithm.InsertionSort;
import sortAlgorithm.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int[] arr = {5, 2, 4, 1, 6, 7};
        int[] sortedArr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        System.out.println(BinarySearch.binarySearch(sortedArr, 23));
        QuickSort.quickSort(arr, 0, 5);
        System.out.println(Arrays.toString(arr));

    }
}