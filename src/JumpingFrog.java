public class JumpingFrog {

    public static int totalJumps(int n) {
        int[][] resultMatrix = new int[n][n];

        if (n == 1)
            return 1;

        for (int i = 0; i < n; i++) {
            resultMatrix[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            resultMatrix[0][j] = 0;
        }

        resultMatrix[0][0] = 1;
        resultMatrix[2][1] = 1;
        resultMatrix[1][2] = 1;

        for (int i = 2; i < n; i++) {
            for (int j = 2; j < n; j++) {
                resultMatrix[i][j] = resultMatrix[i - 2][j - 1] + resultMatrix[i - 1][j - 2];
            }
        }

        return resultMatrix[n - 1][n - 1];

    }

    public static void main(String[] args) {
        for (int i = 1; i < 46; i += 3)
            System.out.println("i : " + i + " total paths :" + totalJumps(i));
    }
}