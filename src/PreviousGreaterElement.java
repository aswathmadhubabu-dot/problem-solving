import java.util.Stack;

public class PreviousGreaterElement {

    private static void ComputePreviousGreaterElement(int[] arr, int n) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(arr[0]);
        System.out.println(-1);
        for (int i = 1; i < n; i++) {
            while (!s.empty() && s.peek() < arr[i]) {
                s.pop();
            }   
            if (s.empty()) {
                System.out.println(-1);
            } else {
                System.out.println(s.peek());
            }
            s.push(arr[i]);
        }
    }

    private static void ComputeNextGreaterElement(int[] arr, int n) {
        Stack<Integer> s = new Stack<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() < arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                System.out.println(-1);
            } else {
                System.out.println(s.peek());
            }
            s.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 20, 40, 12, 30};
        int[] arr2 = {4, 5, 2, 25};
        int n = arr.length;
        int n2 = arr2.length;
        ComputePreviousGreaterElement(arr, n);
        ComputeNextGreaterElement(arr2, n2);
    }
}
