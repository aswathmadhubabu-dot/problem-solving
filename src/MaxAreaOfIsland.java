public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    fillRecursively(grid, i, j, grid[i][j], grid[i][j]);
            }
        }

        int result = 2;

        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    return -1;
                }
                result = Math.max(result, row[j]);
            }
        }

        return result - 2;
    }

    public static void fillRecursively(int[][] image, int sr, int sc,
                                       int currentColor, int newColor) {

        int m = image.length;
        int n = image[0].length;

        if (sr < 0 || sc < 0 || sr >= m || sc >= n ||
                (1 < image[sr][sc] && image[sr][sc] < currentColor) || image[sr][sc] == 0)
            return;

        image[sr][sc] = currentColor;

        fillRecursively(image, sr - 1, sc, currentColor + 1, newColor);

        fillRecursively(image, sr + 1, sc, currentColor + 1, newColor);

        fillRecursively(image, sr, sc - 1, currentColor + 1, newColor);

        fillRecursively(image, sr, sc + 1, currentColor + 1, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        };

        System.out.println(maxAreaOfIsland(image));
    }

}
