public class MaxLeafPath {
    private MaxLeafPath left;
    private MaxLeafPath right;
    private int data;

    public MaxLeafPath(int x) {
        this.left = null;
        this.right = null;
        this.data = x;
    }

    static int findLongestPathLength(MaxLeafPath root) {
        if (root == null)
            return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        return Math.max(1 + lh + rh,
                Math.max(findLongestPathLength(root.left), findLongestPathLength(root.right)));
    }

    static int getHeight(MaxLeafPath t) {
        if (t == null)
            return 0;
        int lHeight = getHeight(t.left);
        int rHeight = getHeight(t.right);

        if (lHeight > rHeight)
            return lHeight + 1;
        else
            return rHeight + 1;
    }

    public static void main(String[] args) {
        MaxLeafPath m = new MaxLeafPath(1);
        m.left = new MaxLeafPath(2);
        m.right = new MaxLeafPath(3);
        m.left.left = new MaxLeafPath(4);
        m.left.right = new MaxLeafPath(5);
        m.left.right.left = new MaxLeafPath(6);
        m.left.right.right = new MaxLeafPath(7);
        m.left.left.right = new MaxLeafPath(8);
        m.left.left.right.left = new MaxLeafPath(9);


        System.out.println(findLongestPathLength(m));
    }


}
