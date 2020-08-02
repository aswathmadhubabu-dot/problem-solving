//import javafx.util.Pair;
//
//import java.util.Map;
//import java.util.TreeMap;
//
//class TopViewofBT {
//    private int key;
//    TopViewofBT left = null, right = null;
//
//    private TopViewofBT(int key) {
//        this.key = key;
//    }
//
//    private static void printTop(TopViewofBT root, int dist, int level,
//                                Map<Integer, Pair<Integer, Integer>> map) {
//        if (root == null) {
//            return;
//        }
//        if (!map.containsKey(dist) || level < map.get(dist).getKey()) {
//            map.put(dist, new Pair<>(root.key, level));
//        }
//        printTop(root.left, dist - 1, level + 1, map);
//        printTop(root.right, dist + 1, level + 1, map);
//    }
//
//    private static void printTop(TopViewofBT root) {
//        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
//        printTop(root, 0, 0, map);
//        for (Pair<Integer, Integer> it : map.values()) {
//            System.out.print(it.getKey() + " ");
//        }
//    }
//
//    public static void main(String[] args) {
//        TopViewofBT root = new TopViewofBT(1);
//        root.left = new TopViewofBT(2);
//        root.right = new TopViewofBT(3);
//        root.left.right = new TopViewofBT(4);
//        root.right.left = new TopViewofBT(5);
//        root.right.right = new TopViewofBT(6);
//        root.right.left.left = new TopViewofBT(7);
//        root.right.left.right = new TopViewofBT(8);
//
//        printTop(root);
//    }
//}