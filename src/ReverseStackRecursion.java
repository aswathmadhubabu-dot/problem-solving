import java.util.Stack;

public class ReverseStackRecursion {

    private static void ReverseStack(Stack<Integer> st, int t) {
        if(!st.isEmpty()){
            t = st.pop();
            ReverseStack(st, t);
            st.push(t);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st =  new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        ReverseStack(st, st.peek());
        for(Integer i : st){
            System.out.println(i);
        }
    }
}
