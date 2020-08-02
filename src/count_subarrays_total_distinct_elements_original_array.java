import java.util.HashMap;

public class count_subarrays_total_distinct_elements_original_array {
    private int getDistinctSubArrays(int[] arr){
        int ans = 0, window = 0, right = 0;
        int n = arr.length;
        HashMap<Integer, Integer> viz = new HashMap<Integer, Integer>() {
            @Override
            public Integer get(Object key) {
                if (!containsKey(key))
                    return 0;
                return super.get(key);
            }
        };

        for(Integer i: arr){
            viz.put(i,1);
        }

        int k = viz.size();
        viz.clear();

        for (int i : arr) {
            while (right < n && window < k) {
                viz.put(arr[right], viz.get(arr[right]) + 1);
                if (viz.get(arr[right]) == 1)
                    ++window;
                ++right;
            }

            if (window == k)
                ans += (n - right + 1);

            viz.put(i, viz.get(i) - 1);
            if (viz.get(i) == 0)
                --window;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 2, 3};
        count_subarrays_total_distinct_elements_original_array c = new count_subarrays_total_distinct_elements_original_array();
        System.out.print(c.getDistinctSubArrays(arr));
    }
}
