import java.util.Stack;

public class Infix_to_postfix {

    private int getprecendence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private String infixtopostfix(char[] str) {
        StringBuilder result = new StringBuilder(new String(""));
        Stack<Character> stack = new Stack<>();
        for (char c : str) {
            if (Character.isLetterOrDigit(c))
                result.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression";
                else
                    stack.pop();
            } else {
                while (!stack.isEmpty() && getprecendence(c) <= getprecendence(stack.peek())) {
                    if (stack.peek() == '(')
                        return "Invalid Expression";
                    result.append(stack.pop());
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        Infix_to_postfix ip = new Infix_to_postfix();
        System.out.println(ip.infixtopostfix(exp.toCharArray()));
    }
}
