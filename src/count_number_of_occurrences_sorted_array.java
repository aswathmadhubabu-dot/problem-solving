public class count_number_of_occurrences_sorted_array {

    private int findOccurences(int[] arr, int x){
        if(arr.length == 0) return 0;

        int pivot = binarySearch(arr, 0, arr.length-1, x);

        if(pivot == -1) return 0;

        int i = pivot,j = pivot + 1;
        int count = 0;
        while(arr[i] == x) {
            count++;
            i--;
        }
        while (arr[j] == x) {
            count++;
            j++;
        }
        return count;
    }

    public int binarySearch(int[] arr, int low, int high, int x) {
        if(low > high){
            return -1;
        }
        int mid = (low+ high) / 2;

        if(arr[mid] == x)
            return mid;

        if(arr[mid] > x)
            return binarySearch(arr, low, mid-1, x);

        return binarySearch(arr, mid+1, high, x);
    }

    public static void main(String[] args) {
      int[] arr = {1, 1, 2, 2, 2, 2, 3};
      int x = 2;

      count_number_of_occurrences_sorted_array ca = new count_number_of_occurrences_sorted_array();
      System.out.print(ca.findOccurences(arr, x));
    }
}
