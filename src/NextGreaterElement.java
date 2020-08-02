import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int arr[] = {13, 7, 6, 12};
        int n = arr.length;
        int[] outputArray = new int[n];

        for (int i = 0; i < n; ++i) outputArray[i] = -1;

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && arr[s.peek()] < arr[i]) {
                int a = s.peek();
                s.pop();
                outputArray[a] = arr[i];
            }
            s.push(i);
        }

        for (int i : outputArray) System.out.println(i);
    }
}
