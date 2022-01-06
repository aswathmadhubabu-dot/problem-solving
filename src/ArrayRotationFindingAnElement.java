public class ArrayRotationFindingAnElement {

    public static int findPivotIndex(int[] arr, int low, int high) {
        if (low > high)
            return -1;

        if (low == high)
            return low;

        int mid = (low + high) / 2;

        // Check if mid is pivot
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;

        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);

        if (arr[low] >= arr[mid])
            return findPivotIndex(arr, low, mid - 1);

        return findPivotIndex(arr, mid + 1, high);
    }

    public static int binarySearch(int[] arr, int low, int high, int x) {
        if (high >= low) {
            int mid = (low + high) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, low, mid - 1, x);

            return binarySearch(arr, mid + 1, high, x);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int pivotPoint = findPivotIndex(arr, 0, arr.length - 1);
        System.out.println(binarySearch(arr, 0, pivotPoint, 10));
        System.out.println(binarySearch(arr, pivotPoint, arr.length - 1, 10));
    }
}
