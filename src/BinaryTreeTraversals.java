import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeTraversals {
    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int x) {
            this.data = x;
            this.left = this.right = null;
        }
    }

    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }

    public void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }

    public int getHeight(Node root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public void levelOrderTraversal(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node top = queue.poll();
            System.out.println(top.data);

            if (top.left != null)
                queue.add(top.left);

            if (top.right != null)
                queue.add(top.right);
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));

        BinaryTreeTraversals binaryTreeTraversals = new BinaryTreeTraversals();
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.right.left = new Node(6);

        /*
                 1
               2   3
            4    5
               6
         */
        System.out.println("Pre Order Traversal");
        binaryTreeTraversals.preOrderTraversal(node);

        System.out.println("Post Order Traversal");
        binaryTreeTraversals.postOrderTraversal(node);

        System.out.println("In Order Traversal");
        binaryTreeTraversals.inOrderTraversal(node);

        System.out.println("Height of binary tree");
        int height = binaryTreeTraversals.getHeight(node);
        System.out.println(height);

        System.out.println("Level Order Traversal");
        binaryTreeTraversals.levelOrderTraversal(node);

    }
}