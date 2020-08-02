public class smallestpivotinrotatedarray {

    private static int minelement(int[] arr, int low, int high) {
        if( high < low) {
            return arr[0];
        }

        if (high == low) return arr[low];

        int mid = (low + high )/ 2;

        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];

        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        if(arr[mid] < arr[high])
            return minelement(arr, low, mid-1);

        return minelement(arr, mid+1, high);
    }

    public static void main (String[] args){
        int[] arr = {5, 6, 1, 2, 3, 4};
        int n = arr.length;
        System.out.print(minelement(arr, 0, n-1));
    }
}
