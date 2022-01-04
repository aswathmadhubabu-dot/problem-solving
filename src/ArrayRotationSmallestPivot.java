public class ArrayRotationSmallestPivot {

    public static int getPivotSmallestElement(int[] arr, int low, int high) {
        if (arr.length == 0)
            return -1;

        if (low > high) return arr[0];

        if (high == low) return arr[low];

        int mid = (low + high) / 2;

        if (mid < high && arr[mid + 1] < arr[mid])
            return arr[mid + 1];


        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        return (arr[high] > arr[mid])
                ? getPivotSmallestElement(arr, low, mid - 1)
                : getPivotSmallestElement(arr, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] pivotArray = {11, 13, 15, 17};

        System.out.println(getPivotSmallestElement(pivotArray, 0, pivotArray.length - 1));
    }
}
