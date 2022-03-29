import java.util.*;

public class KDiffPairs {

    public static int findPairs(int[] nums, int k) {
        int pairs;
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (Integer num : nums) {
            if (map.containsKey(Math.abs(k - num))) {
                map.get(Math.abs(k - num)).add(num);
            }
            map.putIfAbsent(num, new HashSet<>());
        }

        pairs = map.values().stream().mapToInt(Set::size).sum();

        Queue<Node> queue = new ArrayDeque<>();
        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 3, 3, 0, 9, 2, 3};
        int k = 3;
        System.out.println(findPairs(nums, k));
    }
}
