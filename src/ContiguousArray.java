import java.util.HashMap;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        int sumSoFar = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];

            if (sumSoFar == 0)
                maxLen = i + 1;

            if (!map.containsKey(sumSoFar)) {
                map.put(sumSoFar, i);
            }

            if (map.containsKey(sumSoFar)) {
                if (maxLen < (i - map.get(sumSoFar)))
                    maxLen = i - map.get(sumSoFar);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0};
        System.out.println(findMaxLength(arr));
    }
}
