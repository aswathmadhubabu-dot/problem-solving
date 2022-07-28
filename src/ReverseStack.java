import java.util.Stack;

public class ReverseStack {
    static Stack<Integer> st = new Stack<>();

    public static void insertAtBottom(int x) {
        st.push(x);
    }

    public static Stack<Integer> Reverse(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            insertAtBottom(x);
            Reverse(s);
        }
        return st;
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println("Current Top : " + stack.peek());

        Stack<Integer> rvs = Reverse(stack);

        System.out.println(rvs);
        System.out.println("Current Top : " + rvs.peek());
    }
}
