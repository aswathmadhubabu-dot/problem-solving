import java.util.Arrays;

public class PreOrder_to_BST {
    public PreOrder_to_BST left;
    public PreOrder_to_BST right;
    public int data;

    public PreOrder_to_BST() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    public PreOrder_to_BST(int x) {
        this.data = x;
        this.left = null;
        this.right = null;
    }

    public static PreOrder_to_BST insertIntoBst(PreOrder_to_BST root, int data) {
        if (root == null) {
            root = new PreOrder_to_BST(data);
            return root;
        }
        if (root.data > data) {
            root.left = insertIntoBst(root.left, data);
        }
        else {
            root.right = insertIntoBst(root.right, data);
        }
        return root;
    }

    public static void inorderTraversal(PreOrder_to_BST root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.data);
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 1, 7, 40, 50};
        PreOrder_to_BST root = new PreOrder_to_BST(arr[0]);
        arr = Arrays.copyOfRange(arr, 1, arr.length);
        for (int i : arr) {
            insertIntoBst(root, i);
        }
        inorderTraversal(root);
    }
}
