public class isBtaBST {
    private final long data;
    isBtaBST left;
    isBtaBST right;

    private isBtaBST(int x) {
        this.data = x;
        this.left = this.right = null;
    }

    private static boolean isBST(isBtaBST root, Long min, Long max) {
        if(root == null)
            return true;

        if(root.data >= max || root.data <= min)
            return false;

        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        isBtaBST d = new isBtaBST(2);
        isBtaBST f = new isBtaBST(1);
        isBtaBST g = new isBtaBST(3);
        d.left = f;
        d.right = g;
        System.out.println(isBST(d, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}