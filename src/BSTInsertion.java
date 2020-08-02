public class BSTInsertion {
    int data;
    BSTInsertion left;
    BSTInsertion right;

    public BSTInsertion(int x)
    {
        this.data = x;
        this.left = null;
        this.right = null;
    }

    private static BSTInsertion insertintobst (BSTInsertion root, int x)
    {
        if(root == null)
        {
            root = new BSTInsertion(x);
            return root;
        }

        if(x < root.data)
            root.left = insertintobst(root.left ,x);
        else
            root.right = insertintobst(root.right, x);

        return root;
    }

    private static void preordertraversal(BSTInsertion t) {
        if (t != null) {
            System.out.println(t.data);
            preordertraversal(t.left);
            preordertraversal(t.right);
        }
    }

    public static void main (String[] args)
    {
        int[] arr = {15,6,2,8,35,20,45};
        int n = arr.length;
        BSTInsertion bt = new BSTInsertion(arr[0]);

        for(int i =1; i<n ; i++)
        {
           insertintobst(bt, arr[i]);
        }
        preordertraversal(bt);

    }


}
