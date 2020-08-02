public class Array_rotation_smallest {

    public static int modifiedBinarySearch(int[] arr, int min, int max) {
        if (arr.length == 0)
            return 0;
        if (min > max) {
            return arr[0];
        }
        int mid = (min + max) / 2;
        if (arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid]) {
            return arr[mid];
        }
        if (arr[mid - 1] < arr[mid])
            return modifiedBinarySearch(arr, mid + 1, max);
        return modifiedBinarySearch(arr, min, mid);
    }

    private static int binarySearch(int[] arr, int low, int high, int x) {
        if(arr.length == 0)
            return -1;
        if(high == low)
            return low;

        int mid = arr[(low + high) / 2];
        if(arr[mid] == x) {
            return mid;
        }
        if(arr[mid] < x) {
            return binarySearch(arr, mid+1, high, x);
        }
        return binarySearch(arr, low, mid-1, x);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int min = 0;
        int max = arr.length - 1;
        //System.out.println(modifiedBinarySearch(arr, min, max));
        System.out.println(binarySearch(arr, min, max, 6));
    }
}
