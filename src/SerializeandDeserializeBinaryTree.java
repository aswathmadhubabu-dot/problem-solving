import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeandDeserializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void preorderTraversal(TreeNode root, List<String> serializedString) {
        if (root == null)
            serializedString.add("null");
        else {
            serializedString.add(String.valueOf(root.val));
            preorderTraversal(root.left, serializedString);
            preorderTraversal(root.right, serializedString);
        }
    }

    public String Serialize(TreeNode root) {
        List<String> serializedString = new ArrayList<>();
        preorderTraversal(root, serializedString);
        return serializedString.toString();
    }



    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree serializeandDeserializeBinaryTree = new SerializeandDeserializeBinaryTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);

        System.out.println(serializeandDeserializeBinaryTree.Serialize(node));
        String[] str = serializeandDeserializeBinaryTree.Serialize(node).split(",");
        System.out.println(str.toString());
    }

}
