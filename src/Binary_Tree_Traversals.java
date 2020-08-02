import java.util.*;

public class Binary_Tree_Traversals {
    private static class Node {
        private int data;
        private Node left;
        private Node right;

        private Node() {
        }

        private Node(int x) {
            this.data = x;
            this.left = this.right = null;
        }
    }

    private void preorder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    private void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    private int getheight(Node root) {
        if (root == null)
            return 0;

        int leftHeight = getheight(root.left);
        int rightHeight = getheight(root.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    private void printatgivenlevel(Node root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.println(root.data);
        } else if (level > 1) {
            printatgivenlevel(root.left, level - 1);
            printatgivenlevel(root.right, level - 1);
        }
    }

    private void levelorder(Node root) {
        int height = getheight(root);
        for (int i = 1; i <= height; i++) {
            printatgivenlevel(root, i);
        }
    }

    private void printleftview(Node root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.println(root.data);
        } else if (level > 1) {
            printleftview(root.left, level - 1);
        }
    }

    private void leftview(Node root) {
        int height = getheight(root);
        for (int i = 1; i <= height; i++) {
            printleftview(root, i);
        }
    }

    private void printrightview(Node root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.println(root.data);
        } else if (level > 1) {
            printrightview(root.right, level - 1);
        }
    }

    private void rightview(Node root) {
        int height = getheight(root);
        for (int i = 1; i <= height; i++) {
            printrightview(root, i);
        }
    }

    private void updatspiralemap(Node root, int level, HashMap<Integer, Deque<Integer>> map) {
        if (root == null) return;
        if (!map.containsKey(level)) {
            map.put(level, new ArrayDeque<>());
        }
        if ((level % 2 == 1)) {
            map.get(level).addLast(root.data);
        } else {
            map.get(level).addFirst(root.data);
        }

        updatspiralemap(root.left, level +1, map);
        updatspiralemap(root.right, level +1, map);
    }

    private void spiralorder(Node root) {
        HashMap<Integer, Deque<Integer>> map = new HashMap<>();
        updatspiralemap(root, 1, map);
        for(int i = 1; i<= map.size(); i++){
            System.out.printf("Level :%d %s%n", i, map.get(i).toString());
        }
    }

    private void updateverticalmap(Node root, int dist, TreeMap<Integer, List<Integer>> map) {
        if(root == null)
            return;
        if(!map.containsKey(dist)){
            map.put(dist, new ArrayList<>());
        }
        map.get(dist).add(root.data);
        updateverticalmap(root.left, dist-1, map);
        updateverticalmap(root.right, dist+1, map);
    }

    private void verticalorder(Node root){
        if(root == null) return;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        updateverticalmap(root, 0, map);

        for (Collection<Integer> collection: map.values()) {
            System.out.println(collection);
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        Binary_Tree_Traversals btt = new Binary_Tree_Traversals();
        System.out.println("Pre Order");
        btt.preorder(node);
        System.out.println("Post Order");
        btt.postorder(node);
        System.out.println("In Order");
        btt.inorder(node);
        System.out.println("Level Order");
        btt.levelorder(node);
        System.out.println("Left View");
        btt.leftview(node);
        System.out.println("Right View");
        btt.rightview(node);
        System.out.println("Spiral Order");
        btt.spiralorder(node);
        System.out.println("Vertical Order");
        btt.verticalorder(node);
    }
}
