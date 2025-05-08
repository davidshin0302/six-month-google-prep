import leetCodeChallenges.arrays.GreatestCommonDivisor;
import leetCodeChallenges.arrays.KthMissingPositiveNumber;
import searchAlgorithm.BinarySearch;
import searchAlgorithm.BreadthFirstSearch;
import searchAlgorithm.DepthFirstSearch;
import sortAlgorithm.InsertionSort;
import sortAlgorithm.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(0, 5);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(0);

        int[] arr = {5, 2, 4, 1, 6, 7};
        int[] sortedArr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        System.out.println("================");
        System.out.println(BinarySearch.binarySearch(sortedArr, 23));

        System.out.println("================");
        QuickSort.quickSort(arr, 0, 5);
        System.out.println(Arrays.toString(arr));

        System.out.println("================");
        breadthFirstSearch.printResult();

        System.out.println("================");
        depthFirstSearch.printOutput();

        System.out.println("================");
        int[] arr2 =  {2,3,4,7,11}; //k =5, output 9.
        int[] arr3 = {1,2,3,4}; // k =2, output 6. Or alternatively test with [2], k=1, output 1.
        System.out.println(KthMissingPositiveNumber.findMissingPositiveNumber(arr2, 5));

        System.out.println("================");
        int[] num = {7,7,2};
        int output = GreatestCommonDivisor.findGCD(num);
        System.out.println(output);
    }
}