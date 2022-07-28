import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        int n = arr.length;
        int[] outputArray = new int[n];

        Stack<Integer> stack = new Stack<>();
        pGE(arr, n, outputArray, stack);

        for (int i : outputArray) System.out.println(i);
    }

    private static void pGE(int[] arr, int n, int[] outputArray, Stack<Integer> stack) {
        stack.push(arr[0]);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            outputArray[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
    }

    private static void nGE(int[] arr, int n, int[] outputArray, Stack<Integer> stack) {
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            outputArray[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
    }
}
