import java.util.*;

public class Median_of_two_arrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>(nums1.length);
        List<Integer> list2 = new ArrayList<>(nums2.length);

        for (int i : nums1) {
            list1.add(i);
        }
        for (int i : nums2) {
            list2.add(i);
        }
        ArrayList<Integer> and = new ArrayList<>();
        and.addAll(list1);
        and.addAll(list2);

        Collections.sort(and);

        if (and.size() % 2 == 0) {
            return ((and.get(((and.size()) / 2) - 1) + and.get((and.size()) / 2))) /2.0;
        } else {
            return (and.get((and.size()) / 2));
        }
    }

    public static void main(String[] args) {
        int a1[] = {1,2};
        int a3[] = {3,4};
        double a = findMedianSortedArrays(a1, a3);
        System.out.println(a);
    }
}