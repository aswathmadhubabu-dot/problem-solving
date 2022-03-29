import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int right = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 9, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
