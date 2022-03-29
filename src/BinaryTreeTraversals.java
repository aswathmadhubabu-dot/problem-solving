import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversals {
    public static class Node {
        Node left;
        Node right;
        int data;

        public Node(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
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

    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }

    public int getHeight(Node root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public void printNodesAtLevel(Node root, int level) {
        if (root == null) return;

        if (level == 1)
            System.out.println(root.data);
        else if (level > 1) {
            printNodesAtLevel(root.left, level - 1);
            printNodesAtLevel(root.right, level - 1);
        }
    }

    public void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.data);

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    public void printSideView(Node root, HashMap<Integer, Integer> map, int level, boolean isLeft) {
        if (root == null)
            return;

        if (isLeft)
            map.putIfAbsent(level, root.data);
        else
            map.put(level, root.data);

        printSideView(root.left, map, level + 1, isLeft);
        printSideView(root.right, map, level + 1, isLeft);
    }

    public void sideView(Node root, boolean isLeft) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (root == null)
            return;
        printSideView(root, map, 1, isLeft);
        for (int i = 1; i <= map.size(); i++)
            System.out.println(map.get(i));
    }

    public static void main(String[] args) {
        BinaryTreeTraversals binaryTreeTraversals = new BinaryTreeTraversals();
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

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

        System.out.println("Left View of Binary Tree");
        binaryTreeTraversals.sideView(node, true);

        System.out.println("Right View of Binary Tree");
        binaryTreeTraversals.sideView(node, false);
    }
}
