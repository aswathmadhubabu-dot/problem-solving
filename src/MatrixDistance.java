import java.util.Arrays;

public class MatrixDistance {

    public static int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE - 1;

        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                fillDistance(mat, result, i, j);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                fillDistance(mat, result, i, j);

        return result;
    }

    private static void fillDistance(int[][] mat, int[][] result, int i, int j) {
        if (mat[i][j] != 0) {
            if (i - 1 >= 0) {
                result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
            }
            if (j - 1 >= 0) {
                result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
            }
            if (i + 1 < mat.length) {
                result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
            }
            if (j + 1 < mat[0].length) {
                result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 1, 0, 1, 1}
        };
        System.out.println(Arrays.deepToString(updateMatrix(arr)));
    }

}
