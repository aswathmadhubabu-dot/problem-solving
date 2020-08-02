public class RightViewofBT {
    RightViewofBT left;
    RightViewofBT right;
    int data;
    static int maxlevel =0;

    public RightViewofBT(int x)
    {
        this.data = x;
        this.left = this.right = null;
    }

    public static int Height(RightViewofBT tree)
    {
        if (tree == null)
            return 0;

        int lHeight = Height(tree.left);
        int rHeight = Height(tree.right);

        if(lHeight > rHeight)
            return lHeight+1;
        else
            return rHeight+1;
    }

    public static void printRightView(RightViewofBT t, int level)
    {
        if (t == null)
            return;
        if(maxlevel < level)
        {
            System.out.println(t.data);
            maxlevel = level;
        }
        printRightView(t.left, level+1);
        printRightView(t.right, level+1);
    }

    public static void main(String[] args)
    {

        RightViewofBT t = new RightViewofBT(1);
        RightViewofBT l = new RightViewofBT(2);
        RightViewofBT l2 = new RightViewofBT(3);
        RightViewofBT r2 = new RightViewofBT(4);
        RightViewofBT r = new RightViewofBT(5);
        RightViewofBT g = new RightViewofBT(6);
        t.left = l;
        t.right = l2;
        l.right = r2;
        r2.right = r;
        r.right = g;

        int Height = Height(t);
        printRightView(t, 1);

    }

}
