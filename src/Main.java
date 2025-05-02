import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int[] arr =  {5,2,4,1,6};

//        System.out.println(Arrays.toString(insertionSort.practiceInsertion(arr)));

        MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}