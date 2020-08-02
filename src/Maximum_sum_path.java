public class Maximum_sum_path {
    Maximum_sum_path left;
    Maximum_sum_path right;
    private int data;

    public Maximum_sum_path(int x) {
        this.data = x;
        this.left = this.right = null;
    }

    static class A {
        int ans;
    }

    private int getMaximumSumPath(Maximum_sum_path root) {
        A a = new A();
        getMaximum(root, a);
        return a.ans;
    }

    private int getMaximum(Maximum_sum_path root, A a) {
        if (root == null) {
            a.ans = 0;
            return 0;
        }
        if (root.left == null && root.right == null) {
            a.ans = root.data;
            return a.ans;
        }
        int leftMaximum = getMaximum(root.left, a);
        int rightMaximum = getMaximum(root.right, a);
        if (root.left != null && root.right != null) {
            int maximum = leftMaximum + rightMaximum + root.data;
            a.ans = Math.max(a.ans, maximum);
            return Math.max(leftMaximum, rightMaximum) + root.data;
        }
        final int i;
        i = root.left == null ? rightMaximum + root.data : leftMaximum + root.data;
        return i;
    }

    public static void main(String[] args) {
        Maximum_sum_path m = new Maximum_sum_path(1);
        m.left = new Maximum_sum_path(2);
        m.right = new Maximum_sum_path(3);
        m.left.left = new Maximum_sum_path(4);
        m.left.right = new Maximum_sum_path(5);
        m.left.right.left = new Maximum_sum_path(6);
        m.left.right.right = new Maximum_sum_path(7);
        m.left.left.right = new Maximum_sum_path(8);
        m.left.left.right.left = new Maximum_sum_path(9);

        System.out.printf("Maximum sum path : %d", m.getMaximumSumPath(m));

    }
}