import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        int i = 0;
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        while (i < Math.pow(2, n)) {
            int j = 0;
            while (j < n) {
                if ((i & (1 << j)) > 0)
                    combination.add(j + 1);
                j++;
            }
            if (combination.size() == k)
                combinations.add(combination);
            i = i + 1;
        }
        return combinations;
    }

    public static void main(String[] args) {
    }
}
