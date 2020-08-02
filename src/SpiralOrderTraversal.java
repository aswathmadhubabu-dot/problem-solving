import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class SpiralOrderTraversal {
    private static class Node {
        Node left;
        Node right;
        private int data;

        private Node(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }

    private int getHeight(Node root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    private void updateSpiralMap(int level, HashMap<Integer, Deque<Integer>> map, Node root) {
        if (root == null)
            return;
        if (!map.containsKey(level)) {
            map.put(level, new ArrayDeque<>());
        }
        if (level % 2 == 1) {
            map.get(level).addLast(root.data);
        } else if (level % 2 == 0) {
            map.get(level).addFirst(root.data);
        }
        updateSpiralMap(level + 1, map, root.left);
        updateSpiralMap(level + 1, map, root.right);
    }

    private void printInSpiralOrder(Node root) {
        HashMap<Integer, Deque<Integer>> map = new HashMap();
        updateSpiralMap(1, map, root);
        for (int i = 1; i <= map.size(); i++) {
            System.out.println(i + map.get(i).toString());
        }
    }

    public static void main(String[] args) {
        SpiralOrderTraversal spiralOrderTraversal = new SpiralOrderTraversal();

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        spiralOrderTraversal.printInSpiralOrder(node);
    }


}
