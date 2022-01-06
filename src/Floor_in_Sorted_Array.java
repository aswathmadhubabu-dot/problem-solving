import java.util.Scanner;

public class Floor_in_Sorted_Array {

    private static int floorInSortedArray(int[] arr, int x, int low, int high) {
        if (low > high)
            return -1;

        if (x >= arr[high])
            return arr[high];

        int mid = (low + high) / 2;

        if (arr[mid] == x)
            return arr[mid];

        if (mid > 0 && arr[mid - 1] <= x && arr[mid] > x) {
            return arr[mid - 1];
        }

        if (x < arr[mid])
            return floorInSortedArray(arr, x, low, mid - 1);

        return floorInSortedArray(arr, x, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 10, 12, 14};
        System.out.println(floorInSortedArray(arr, 5, 0, arr.length - 1));
    }

}
