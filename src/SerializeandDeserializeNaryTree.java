import java.lang.reflect.Array;
import java.util.*;

public class SerializeandDeserializeNaryTree {
    public static class Node {
        int data;
        ArrayList<Node> children = null;

        private Node(int d) {
            this.data = d;
            this.children = new ArrayList<Node>();
        }
    }

    private static String serialize(Node t, StringBuilder sb) {
        int i = 0;
        sb.append(t.data);
        sb.append(" ");
        for (int j = 0; j < t.children.size(); j++)
            serialize(t.children.get(j), sb);
        sb.append("# ");
        return sb.toString();
    }

    private static Node deserialize(String str) {
        String[] temparray = str.split(" ");
        Node root = new Node(Integer.valueOf(temparray[0]));
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        int i = 1;
        while (!que.isEmpty()) {
            Node node = que.poll();
            i++;
            while (!temparray[i].equals("#")) {
                Node c = new Node(Integer.valueOf(temparray[i]));
                node.children.add(c);
                que.add(c);
                i++;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node t = new Node(10);
        Node m = new Node(20);
        Node f = new Node(30);
        Node g = new Node(40);
        Node h = new Node(50);
        Node i = new Node(60);
        Node j = new Node(70);
        Node k = new Node(80);
        Node l = new Node(90);
        t.children.add(m);
        t.children.add(f);
        t.children.add(j);
        m.children.add(g);
        g.children.add(h);
        f.children.add(i);
        j.children.add(k);
        k.children.add(l);
//            t.children.forEach(x-> System.out.println(x.data));
//            System.out.println(t.children.size());
        StringBuilder sb= new StringBuilder();
        String serialized = serialize(t, sb);
        System.out.println(serialized);

        System.out.println(Integer.valueOf("10"));
        Node again =deserialize(serialized);
        System.out.println(again.children.size());
    }
}

