public class QuickSort {

    private static void quicksort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        if (arr.length == 0)
            return;
        int pivot = arr[(low + high) / 2];
        if (j <= i) {
            return;
        }

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
            if (low < j) {
                quicksort(arr, low, j);
            }
            if (i < high) {
                quicksort(arr, i, high);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 4, 5, 3};
        int low = 0;
        int high = arr.length - 1;
        quicksort(arr, low, high);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
