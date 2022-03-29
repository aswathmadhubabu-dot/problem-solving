import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], i);
            if (map.containsKey(target - nums[i]) && i > 0) {
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
                return arr;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}
