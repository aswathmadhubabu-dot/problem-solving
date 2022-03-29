import java.util.Arrays;

class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int l = 0;
        int n = nums.length;

        int r = n - 1;
        int k = n - 1;

        int[] output = new int[n];

        while (l <= r) {
            int left = (int) Math.pow(nums[l], 2);
            int right = (int) Math.pow(nums[r], 2);

            if (left >= right) {
                output[k--] = left;
                l++;
                continue;
            }
            output[k--] = right;
            r--;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 0, 2};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}