import java.util.ArrayDeque;
import java.util.Deque;

public class Ancestors {

    private final int data;
    Ancestors left;
    Ancestors right;

    public Ancestors(int x) {
        this.data = x;
        this.left = this.right = null;
    }

    public static boolean getAncestors(Ancestors tree, int target) {
        if (tree == null) {
            return false;
        }
        if (tree.data == target) {
            return true;
        }
        if (getAncestors(tree.left, target) || getAncestors(tree.right, target)) {
            System.out.print(tree.data + " ");
            return true;
        }
        return false;
    }

    public static Ancestors getCommonAncestors(Ancestors tree, Ancestors x, Ancestors y) {
        if(tree == null)
            return null;

        if(x.data > tree.data && y.data > tree.data)
            return getCommonAncestors(tree.right, x, y);

        if(x.data < tree.data && y.data < tree.data)
            return getCommonAncestors(tree.left, x, y);

        return tree;
    }

    public static void main(String[] args) {
        Ancestors tree = new Ancestors(0);
        tree.left = new Ancestors(1);
        tree.right = new Ancestors(2);
        tree.left.left = new Ancestors(3);
        tree.left.right = new Ancestors(4);
        tree.right.left = new Ancestors(5);
        tree.right.right = new Ancestors(6);
        tree.left.left.left = new Ancestors(7);
        tree.left.right.left = new Ancestors(8);
        tree.left.right.right = new Ancestors(9);

        getAncestors(tree, 9);
        System.out.println("--");
        getAncestors(tree, 6);
        System.out.println("--");

        System.out.println(getCommonAncestors(tree, tree.left.left.left, tree.right).data);
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
