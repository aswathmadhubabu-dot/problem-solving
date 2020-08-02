import java.util.HashMap;

public class MaxLengthSubArray {

    public static void printMaxSubArrayWithGivenSum(int[] arr, int s) {
        int A = arr.length;
        if (A == 0) {
            return;
        }

        int len = 0;
        HashMap<Integer, Integer> map = new HashMap();
        int endingIndex = -1;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < A; i++) {
            sum += arr[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - s) && len < (i - map.get(sum - s))) {
                len = i - map.get(sum - s);
                endingIndex = i;
            }
        }
        System.out.println("Starting Index : " + (endingIndex - len + 1) + "Ending Index: " + (endingIndex));
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        printMaxSubArrayWithGivenSum(arr, 5);
    }
}
