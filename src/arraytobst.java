import java.util.Comparator;
import java.util.PriorityQueue;

public class arraytobst {
    public static class Node {
        private int data;
        Node left;
        Node right;

        public Node(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }

    public static Node constructBinaryTree(int[] arr, int low, int high) {
        if (high < low)
            return null;
        int mid = (low + high) / 2;
        Node root = new Node(arr[mid]);
        root.left = constructBinaryTree(arr, low, mid - 1);
        root.right = constructBinaryTree(arr, mid + 1, high);
        return root;
    }

    public static void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node node = constructBinaryTree(arr, 0, arr.length - 1);
        printInorder(node);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });
    }
}
