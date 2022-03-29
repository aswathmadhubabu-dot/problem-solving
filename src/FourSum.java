import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FourSum {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int n = nums1.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(nums1[i] + nums2[j], new ArrayList<>());
                Collections.addAll(map.get(nums1[i] + nums2[j]), i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                if (map.containsKey(-(sum))) {
                    if (map.get(-sum).size() >= 4)
                        count = count + (map.get(-sum).size() / 2);
                    else
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
