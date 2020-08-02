import java.util.Iterator;
import java.util.LinkedList;
public class LinkedListImplementation {
    public static class Node {
        Node left;
        Node right;
        int data;

        public Node(int x)
        {
            this.data = x;
            this.left = this.right = null;
        }
    }
    public static void inordertraversal(Node n , LinkedList<Integer> list)
    {
        if(n != null)
        {
            inordertraversal(n.left, list);
            list.add(n.data);
            inordertraversal(n.right, list);
        }
    }

    public static LinkedList<Integer> btoDll (Node root)
    {
        if(root == null)
        {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        inordertraversal(root, list);
        return list;
    }

    public static void main (String[] args)
    {

        Node n = new Node(10);
        n.left = new Node(20);
        n.right = new Node(30);
        n.left.left = new Node(40);
        n.left.right = new Node(60);

        LinkedList<Integer> finalll = btoDll(n);

        Iterator<Integer> it = finalll.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }

    }
}
