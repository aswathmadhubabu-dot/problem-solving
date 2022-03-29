import java.util.Arrays;

public class RotateArrayKSteps {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;

        rotateArray(nums, 0, nums.length - k - 1);
        rotateArray(nums, nums.length - k, nums.length - 1);
        rotateArray(nums, 0, nums.length - 1);
    }

    public static void rotateArray(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int num = nums[left];
        nums[left] = nums[right];
        nums[right] = num;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

    }
}
