//import javafx.util.Pair;
//import java.util.TreeMap;
//
//public class kth_smallest_row_wise_column_wise {
//   public static void main(String[] args) {
//       int[][] mat = {{10, 20, 30, 40},
//               {15, 25, 35, 45},
//               {24, 29, 37, 48},
//               {32, 33, 39, 50},
//       };
//       TreeMap<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
//       int m = mat.length;
//       for(int i=0;i<m;i++){
//           map.put(mat[0][i], new Pair<>(0,i));
//       }
//
//       for(int i=0;i<5;i++){
//           int tempj = map.get(map.firstKey()).getValue();
//           int tempi = map.get(map.firstKey()).getKey();
//           map.remove(map.firstKey());
//           map.put(mat[tempi+1][tempj], new Pair<>(tempi+1, tempj));
//       }
//
//       System.out.println(map.firstKey());
//   }
//}
