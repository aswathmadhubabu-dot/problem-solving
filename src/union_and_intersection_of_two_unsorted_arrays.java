import java.util.Arrays;

public class union_and_intersection_of_two_unsorted_arrays {

    private void Union(int[] arr1, int[] arr2){

        Arrays.sort(arr1);
        for (Integer i : arr1)
            System.out.println(i);

        for(Integer i : arr2)
            if (!binarySearch(arr1, i, 0, arr1.length - 1)) System.out.println(i);
    }

    private void Intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        for(Integer i : arr2) {
            if(binarySearch(arr1, i, 0, arr1.length -1)) {
                System.out.println(i);
            }
        }
    }

    private boolean binarySearch(int[] arr, int x, int low, int high){
        if(high < low)
            return false;

        int mid = (low + high)/ 2;
        if(arr[mid] == x)
            return true;

        if(arr[mid] < x)
            return binarySearch(arr, x, mid+1, high);

        return binarySearch(arr, x, low, mid-1);
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 1, 5, 2, 3, 6};
        int[] arr2 = {3, 8, 6, 20, 7};

        union_and_intersection_of_two_unsorted_arrays ui = new union_and_intersection_of_two_unsorted_arrays();
        ui.Union(arr1, arr2);
        ui.Intersection(arr1, arr2);

    }
}
