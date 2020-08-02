import java.util.HashMap;
import java.util.Map;

public class Node {
    int data;
    Node left, right;
    Node random;
    Node(int data) {
        this.data = data;
    }
};

class Main {
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " -> (");
        System.out.print((root.left != null ? root.left.data : "X") + ", ");
        System.out.print((root.right != null ? root.right.data : "X") + ", ");
        System.out.println((root.random != null ? root.random.data : "X") + ")");
        preorder(root.left);
        preorder(root.right);
    }

    public static void updateRandomPointers(Node root, Map<Node, Node> map) {
        if (map.get(root) == null) {
            return;
        }
        map.get(root).random = map.get(root.random);
        updateRandomPointers(root.left, map);
        updateRandomPointers(root.right, map);
    }

    public static Node cloneLeftRightPointers(Node root, Map<Node, Node> map) {
        if (root == null) {
            return null;
        }
        map.put(root, new Node(root.data));
        map.get(root).left = cloneLeftRightPointers(root.left, map);
        map.get(root).right = cloneLeftRightPointers(root.right, map);
        return map.get(root);
    }

    public static Node cloneSpecialBinaryTree(Node root) {
        Map<Node, Node> map = new HashMap<>();
        cloneLeftRightPointers(root, map);
        updateRandomPointers(root, map);
        return map.get(root);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.random = root.right.left.random;
        root.left.left.random = root.right;
        root.left.right.random = root;
        root.right.left.random = root.left.left;
        root.random = root.left;

        System.out.println("Preorder traversal of the original tree:");
        preorder(root);

        Node clone = cloneSpecialBinaryTree(root);

        System.out.println("\nPreorder traversal of the cloned tree:");
        preorder(clone);
    }
}

