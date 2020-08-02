import java.util.Stack;

public class HistogramAreaProblem {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int n = arr.length;
        int top;
        int maximumArea = 0;
        int areaWithTop;
        int i = 0;
        Stack<Integer> st = new Stack<>();
        while (i < n) {
            if (st.isEmpty() || arr[st.peek()] <= arr[i]) {
                st.push(i++);
            } else {
                top = st.pop();
                areaWithTop = arr[top] * (st.isEmpty() ? i : i - st.peek());

                if (maximumArea < areaWithTop)
                    maximumArea = areaWithTop;
            }
        }
        while (!st.isEmpty()) {
            top = st.pop();
            areaWithTop = arr[top] * (st.isEmpty() ? i : i - st.peek());

            if (maximumArea < areaWithTop)
                maximumArea = areaWithTop;
        }
        System.out.println(maximumArea);
    }
}
