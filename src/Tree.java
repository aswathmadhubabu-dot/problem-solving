import java.util.Stack;

public class Tree {
    private Tree left;
    private Tree right;
    private int data;

    public Tree(int x) {
        this.left = null;
        this.right = null;
        this.data = x;
    }

    public static void preordertraversal(Tree t) {
        if (t != null) {
            System.out.println(t.data);
            preordertraversal(t.left);
            preordertraversal(t.right);
        }
    }

    public static void postordertraversal(Tree t) {
        if (t != null) {
            postordertraversal(t.left);
            postordertraversal(t.right);
            System.out.println(t.data);
        }
    }

    public static void inordertraversal(Tree t) {
        if (t != null) {
            inordertraversal(t.left);
            System.out.println(t.data);
            inordertraversal(t.right);
        }
    }

    public static int Height(Tree t) {
        if (t == null)
            return 0;
        int lHeight = Height(t.left);
        int rHeight = Height(t.right);

        if (lHeight > rHeight)
            return lHeight + 1;
        else
            return rHeight + 1;
    }

    public static void printatgivenlevel(Tree t, int level) {
        if (t == null) return;
        if (level == 1)
            System.out.println(t.data);
        else if (level > 1) {
            printatgivenlevel(t.right, level - 1);
            printatgivenlevel(t.left, level - 1);
        }
    }

    public static void leftviewofBT(Tree t, int level) {

        if (t == null) return;

        if (level == 1) {
            System.out.println(t.data);

        } else if (level > 1) {
            leftviewofBT(t.left, level - 1);
        }
    }

    public static void rightviewofBT(Tree t, int level) {

        if (t == null) return;

        if (level == 1) {
            System.out.println(t.data);

        } else if (level > 1) {
            rightviewofBT(t.right, level - 1);
        }
    }


    public static void main(String[] args) {
        Tree t = new Tree(10);
        t.left = new Tree(5);
        t.right = new Tree(15);
        t.right.left = new Tree(13);
        t.right.right = new Tree(16);
        t.left.left = new Tree(2);
        t.left.right = new Tree(6);

//        preordertraversal(t);
//        postordertraversal(t);
//        inordertraversal(t);
        int cnt = Height(t);

//        for (int i = 1; i <= cnt; i++) {
//            rightviewofBT(t, i);
//        }
//
//        for (int i = 1; i <= cnt; i++) {
//            leftviewofBT(t, i);
//        }

        for (int i = 1; i <= cnt; i++) {
            printatgivenlevel(t, i);
        }

       // printatgivenlevel(t.right, 2);

    }
}