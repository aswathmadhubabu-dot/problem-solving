import java.util.Stack;

class MyStack {
    private final Stack<Integer> stack;
    private int minElement;

    public MyStack() {
        stack = new Stack<>();
    }

    public void getMin() {
        if (stack.isEmpty()) {
            System.out.println("Stack empty");
        } else {
            System.out.println(minElement);
        }
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            minElement = x;
            stack.push(x);
        }
        if (x < minElement) {
            stack.push(2 * x - minElement);
            minElement = x;
        } else {
            stack.push(x);
        }

    }

    public void pop() {
        int top = stack.pop();
        if (top < minElement) {
            minElement = 2 * minElement - top;
        }
    }


    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.getMin();
    }
}



