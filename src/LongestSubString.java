import java.util.Arrays;
import java.util.Stack;

public class LongestSubString {

    private static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = '*';
        Stack st = new Stack();
        st.empty();
        int cur = 0, max = 0;
        boolean isSame = true;

        if (arr.length == 0) return 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] != arr[0]) isSame = false;

        if (!isSame) {
            for (char c : arr) {
                if (st.contains(c)) {
                    cur = 1;
                } else {
                    st.push(c);
                    cur++;
                }

                if (cur > max) max = cur;
            }
            return max;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
