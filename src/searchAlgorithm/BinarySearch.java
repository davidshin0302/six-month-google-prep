package searchAlgorithm;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                mid = low + 1;
            } else {
                mid = high - 1;
            }
        }
        return -1;
    }
}
