public class isSumTree {
    private int key;
    isSumTree left;
    isSumTree right;

    private isSumTree(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
    private static int SumTree(isSumTree root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.key;
        }
        if (root.key == SumTree(root.left) + SumTree(root.right)) {
            return 2 * root.key;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        isSumTree root = new isSumTree(44);
        root.left = new isSumTree(9);
        root.right = new isSumTree(13);
        root.left.left = new isSumTree(4);
        root.left.right = new isSumTree(5);
        root.right.left = new isSumTree(6);
        root.right.right = new isSumTree(7);

        if (SumTree(root) != Integer.MIN_VALUE) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

}
