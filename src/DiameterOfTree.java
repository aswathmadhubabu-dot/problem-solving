
public class DiameterOfTree {
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

    static int diameter;

    public int getDiameter(Node root) {
        if (root == null)
            return 0;

        int leftHeight = getDiameter(root.left);
        int rightHeight = getDiameter(root.right);

        int currentDiameter = leftHeight + rightHeight + 1;

        diameter = Math.max(diameter, currentDiameter);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        DiameterOfTree diameterOfTree = new DiameterOfTree();
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        diameter = 0;
        diameterOfTree.getDiameter(node);
        System.out.println(diameter);
    }
}
