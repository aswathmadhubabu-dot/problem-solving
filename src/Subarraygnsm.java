import java.util.*;

class Subarraygnsm {

    public static void subArraySum(int[] arr, int n, int sum) {
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            hashMap.put(cur_sum, i);

        }
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }

    }

    // Driver code 
    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int n = arr.length;
        int sum = 33;
        subArraySum(arr, n, sum);

    }
} 