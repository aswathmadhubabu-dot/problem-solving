import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class flatteningLL {
    int data;
    flatteningLL next;
    flatteningLL down;

    public flatteningLL(int x) {
        this.data = x;
        this.next = null;
        this.down = null;
    }

    public static flatteningLL merge(flatteningLL A, flatteningLL B) {
        if (A == null)
            return B;
        if (B == null)
            return A;
        if (A.data < B.data) {
            A.down = merge(A.down, B);
            return A;
        } else {
            B.down = merge(A, B.down);
            return B;
        }
    }

    public static void main(String[] args) {
        flatteningLL node = new flatteningLL(5);
        node.next = new flatteningLL(10);
        node.next.down = new flatteningLL(20);
        node.down = new flatteningLL(7);
        node.down.down = new flatteningLL(8);
        node.down.down.down = new flatteningLL(30);

        // expected output 5,7,8,10,20,30

//        while (node.next != null) {
//            node = merge(node, node.next);
//        }
        Queue<Integer> q = new PriorityQueue<>();
        q.add(1);
        q.add(3);
        q.add(4);
        System.out.println();
    }
}
