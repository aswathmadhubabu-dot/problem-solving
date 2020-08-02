import java.util.Stack;

public class check_two_expressions_brackets {

    private boolean isEqual(String exp1, String exp2) {
        Stack<Character> stk1 = new Stack<Character>();
        Stack<Character> stk2 = new Stack<Character>();

        char[] str1 = exp1.toCharArray();
        char[] str2 = exp2.toCharArray();
        boolean isValid = false;
        for (Character c : str1) {
            if (c == ')' && isValid) {
                while (!stk1.empty() && stk1.peek() != '(') {
                    stk2.push(stk1.pop());
                }
                isValid = false;
                if (stk1.peek() == '(') {
                    stk1.pop();
                }
                if (stk1.peek() == '-') {
                    while (!stk2.isEmpty()) {
                        if (stk2.peek() == '+'){
                            stk1.push('-');
                            stk2.pop();
                        }
                        else if (stk2.peek() == '-'){
                            stk1.push('+');
                            stk2.pop();
                        }
                        else
                            stk1.push(stk2.pop());
                    }
                }
            } else if (c == '(') {
                isValid = true;
                stk1.push(c);
            } else {
                stk1.push(c);
            }
        }

        for (Character ch : str2) {
            stk2.push(ch);
        }

        return stk1.equals(stk2);
    }

    public static void main(String[] args) {
        check_two_expressions_brackets ieq = new check_two_expressions_brackets();
        String exp1 = "a-b-(c-d)", exp2 = "a-b-c+d";
        char buf1[] = new char[5];
        char buf2[] = new char[8];
        System.out.println(ieq.isEqual(exp1, exp2));
    }
}
