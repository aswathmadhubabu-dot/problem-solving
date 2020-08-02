
public class Diameter_of_Tree {
    private Diameter_of_Tree left;
    private Diameter_of_Tree right;
    private int data;

    public Diameter_of_Tree() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    private Diameter_of_Tree(int x) {
        this.data = x;
        this.left = null;
        this.right = null;
    }

    public static class A {
        int ans = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Diameter_of_Tree d = new Diameter_of_Tree(1);


        d.left = new Diameter_of_Tree(2);
        d.right = new Diameter_of_Tree(8);
        d.left.left = new Diameter_of_Tree(4);
        d.left.right = new Diameter_of_Tree(5);
        d.left.right.right = new Diameter_of_Tree(6);

        System.out.println(getDiameter(d));
    }

    private static int getDiameter(Diameter_of_Tree root) {
        A a = new A();
        getDiameter(root, a);
        return a.ans;
    }

    private static int getDiameter(Diameter_of_Tree root, A a) {
        if (root == null) return 0;
        int left_height = getDiameter(root.left, a);
        int right_height = getDiameter(root.right, a);
        int Max_Diameter = left_height + right_height + 1;
        a.ans = Math.max(a.ans, Max_Diameter);
        return Math.max(left_height, right_height) +1;
    }
}
