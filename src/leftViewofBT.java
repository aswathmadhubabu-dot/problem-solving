public class leftViewofBT {
    leftViewofBT left;
    leftViewofBT right;
    int data;
    static int max = 0;
    public leftViewofBT(int z){
        this.data =z;
        this.left = this.right = null;
    }

    public static void main (String[] args)
    {
        leftViewofBT t = new leftViewofBT(1);
        leftViewofBT l = new leftViewofBT(2);
        leftViewofBT l2 = new leftViewofBT(3);
        leftViewofBT r2 = new leftViewofBT(4);
        leftViewofBT r = new leftViewofBT(5);
        leftViewofBT g = new leftViewofBT(6);
        t.left = l;
        t.right = l2;
        l.right = r2;
        r2.right = r;
        r.right = g;

        int height = Height(t);
        printLeftView(t,1);
    }

    public static void printLeftView(leftViewofBT t, int level)
    {
        if(t == null)
            return;
        if(max < level)
        {
            System.out.println(t.data);
            max = level;
        }
        printLeftView(t.left, level-1);
    }

    public static int Height(leftViewofBT tree)
    {
        if(tree == null)
        {
            return 0;
        }
        int lHeight = Height(tree.left);
        int rHeight = Height(tree.right);

        if(lHeight > rHeight)
            return lHeight+1;
        else
            return rHeight+1;
    }
}
