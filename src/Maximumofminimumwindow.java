import java.util.Arrays;
import java.util.Stack;

public class Maximumofminimumwindow {
    public static int[] getMaximumofMinimumWindow(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }
        // next smaller from left
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            if (!st.isEmpty())
                left[i] = st.peek();
            st.push(i);
        }
        st.clear();
        // next smaller from right
        for (int i = n - 1; i > 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            if (!st.isEmpty())
                right[i] = st.peek();
            st.push(i);
        }
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++)
            ans[i] = 0;

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};
        System.out.println(Arrays.toString(getMaximumofMinimumWindow(arr)));
    }
}
