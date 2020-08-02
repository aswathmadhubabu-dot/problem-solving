public class isBtaBST {
    private int data;
    isBtaBST left;
    isBtaBST right;

    private isBtaBST(int x) {
        this.data = x;
        this.left = this.right = null;
    }

    private static boolean isbinarysearchtree(isBtaBST root, int min, int max) {
        if (root == null)
            return true;

        if (root.data > max || root.data < min)
            return false;

        return isbinarysearchtree(root.left, min, root.data - 1) && isbinarysearchtree(root.right, root.data + 1, max);
    }

    public static void main(String[] args) {
        isBtaBST d = new isBtaBST(2);
        isBtaBST f = new isBtaBST(1);
        isBtaBST g = new isBtaBST(3);
        d.left = f;
        d.right = g;
        System.out.println(isbinarysearchtree(d, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}