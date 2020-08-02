import java.util.Stack;

public class ReverseStack {
    Stack<Integer> st = new Stack<Integer>();

    public Stack<Integer> insert_at_bottom(int x) {
        st.push(x);
        return st;
    }

    public Stack<Integer> Reverse(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            insert_at_bottom(x);
            Reverse(s);
        }
        return st;
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println("Current Top : " + stack.peek());
        String s = "";
        ReverseStack rv = new ReverseStack();
        Stack<Integer> rvs = rv.Reverse(stack);
        System.out.println(rvs);
        System.out.println("Current Top : " + rvs.peek());
    }
}
