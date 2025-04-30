public class InsertionSort {
    public int[] practiceInsertion(int[] arr) {
        if (arr.length <= 0 || arr.length == 1) {
            return null;
        }

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return arr;
    }
}
