import java.util.ArrayList;
import java.util.List;

public class MergeTwoBinaryTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int x) {
            this.data = x;
            this.left = this.right = null;
        }
    }

    public static List<Integer> getPreOrderSequence(Node root, List<Integer> preOrder) {
        if (root == null) {
//            preOder.add(0);
            return preOrder;
        }

        preOrder.add(root.data);
        getPreOrderSequence(root.left, preOrder);
        getPreOrderSequence(root.right, preOrder);

        return preOrder;
    }

    public static List<Integer> getInOrderSequence(Node root, List<Integer> inOrder) {
        if (root == null) {
//            preOder.add(0);
            return inOrder;
        }

        getInOrderSequence(root.left, inOrder);
        inOrder.add(root.data);
        getInOrderSequence(root.right, inOrder);

        return inOrder;
    }

    public static List<Integer> getPostOrderTraversal(Node root, List<Integer> postOrder) {
        if (root == null) {
//            preOder.add(0);
            return postOrder;
        }

        getPostOrderTraversal(root.left, postOrder);
        getPostOrderTraversal(root.right, postOrder);
        postOrder.add(root.data);

        return postOrder;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();


        System.out.println(getPreOrderSequence(node, preOrder));
        System.out.println(getInOrderSequence(node, inOrder));
        System.out.println(getPostOrderTraversal(node, postOrder));

    }
}
