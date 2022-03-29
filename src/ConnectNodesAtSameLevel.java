import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ConnectNodesAtSameLevel {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        public Node(int x) {
            this.data = x;
            this.left = this.right = null;
            this.nextRight = null;
        }
    }

    private static int getHeight(Node root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    private static void constructMap (Node root, int level, HashMap<Integer, Deque<Integer>> map) {
        if(root == null)
            return;
        if(level == 1) {
            if(!map.containsKey(level)) {
                map.put(level, new ArrayDeque<>());

            }
            map.get(level).addLast(root.data);
        }
        constructMap(root.left, level -1, map);
        constructMap(root.right, level -1, map);
    }

    public static void linkRightPointer(Node root) {
        int height  = getHeight(root);
        HashMap<Integer, Deque<Integer>> map = new HashMap<>();
        for(int i = 1; i<= height; i++) {
            constructMap(root, i, map);
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        ConnectNodesAtSameLevel connectNodesAtSameLevel = new ConnectNodesAtSameLevel();
        Node node = new Node(10);
        node.left = new Node(8);
        node.right = new Node(2);
        node.left.left = new Node(3);
        linkRightPointer(node);
    }
}
