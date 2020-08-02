import java.util.HashMap;
import java.util.Map;

public class Trie {
    private boolean isLeaf;
    private Map<Character, Trie> children;

    private Trie() {
        isLeaf = false;
        children = new HashMap<>();
    }

    private void insert(String key) {
        Trie curr = this;
        for (int i = 0; i < key.length(); i++) {
            if (curr.children.get(key.charAt(i)) == null)
                curr.children.put(key.charAt(i), new Trie());
            curr = curr.children.get(key.charAt(i));
        }
        curr.isLeaf = true;
    }

    private boolean search(String key) {
        Trie curr = this;
        for (int i = 0; i < key.length(); i++) {
            curr = curr.children.get(key.charAt(i));
            if (curr == null)
                return false;
        }
        return curr.isLeaf;
    }

    public static void main(String[] args) {
        Trie head = new Trie();
        head.insert("techie");
        head.insert("techi");
        head.insert("tech");
        head.insert("techno");
        System.out.println(head.search("tech"));
        System.out.println(head.search("techi"));
        System.out.println(head.search("techie"));
        System.out.println(head.search("techiedelight"));
        head.insert("techiedelight");
        System.out.println(head.search("tech"));
        System.out.println(head.search("techi"));
        System.out.println(head.search("techie"));
        System.out.println(head.search("techiedelight"));
    }

}
