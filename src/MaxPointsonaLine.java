import java.util.TreeMap;

public class MaxPointsonaLine {
    public static int maxPoints(int[][] points) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int[] point : points) {
            tm.put(point[0], point[1]);
        }
        int m = tm.lastEntry().getKey() + 1;
        int [][] result = new int[m][m];
        for(int[] point : points) {
            result[point[0]][point[1]] = 1;
        }
        int max = 0;
        int sum = 0;
        for(int i =0 ; i<m; i++) {
            for(int j =0 ; i<m; i++) {
                if(result[i][j] == 1) {
                    sum+= 1;
                }
                if(max < sum)
                    max = sum;

                sum = 0;
            }
        }
        return 0;
    }

    public static void main (String[] args) {
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(points));
    }

}
