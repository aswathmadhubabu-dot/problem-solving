import java.util.ArrayDeque;
import java.util.Deque;

public class PrintAncestors {

    private int data;
    PrintAncestors left;
    PrintAncestors right;

    public PrintAncestors(int x) {
        this.data = x;
        this.left = this.right = null;
    }

    public static boolean printallancestors(PrintAncestors tree, int target) {
        if (tree == null) {
            return false;
        }
        if (tree.data == target) {
            return true;
        }
        if (printallancestors(tree.left, target) || printallancestors(tree.right, target)) {
            System.out.print(tree.data + " ");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PrintAncestors tree = new PrintAncestors(0);
        tree.left = new PrintAncestors(1);
        tree.right = new PrintAncestors(2);
        tree.left.left = new PrintAncestors(3);
        tree.left.right = new PrintAncestors(4);
        tree.right.left = new PrintAncestors(5);
        tree.right.right = new PrintAncestors(6);
        tree.left.left.left = new PrintAncestors(7);
        tree.left.right.left = new PrintAncestors(8);
        tree.left.right.right = new PrintAncestors(9);

        printallancestors(tree, 9);
        System.out.println("--");
        printallancestors(tree, 6);
        System.out.println("--");
//        printallancestors(tree, 4);
//        System.out.println("--");
//        printallancestors(tree, 5);
//        System.out.println("--");
//        printallancestors(tree, 6);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);
        dq.addLast(2);
    }
}
