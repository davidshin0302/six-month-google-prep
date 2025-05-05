import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int[] arr = {5, 2, 4, 1, 6, 7};

//        System.out.println(Arrays.toString(insertionSort.practiceInsertion(arr)));

//        MergeSort.mergeSort(arr);
        QuickSort.quickSort(arr, 0, 5);
        System.out.println(Arrays.toString(arr));
    }
}