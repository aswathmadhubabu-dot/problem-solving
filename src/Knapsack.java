class Knapsack {
    private static int sack(int W, int[] wt, int[] val, int n) {
        int i, w;
        int[][] K = new int[n + 1][W + 1];
        for (i = 0; i <= n; i++) K[i][0] = 0;
        for (w = 0; w <= W; w++) K[0][w] = 0;

        for (i = 1, w = 1; w <= W; w++) {
            if (w <= val[0])
                K[i][w] = wt[0];
            else
                K[i][w] = 0;
        }

        int value_so_far = val[0];
        for (i = 2; i <= n; i++) {
            value_so_far += val[i - 1];
            for (w = 1; w <= W; w++) {
                // Straight up
                if (val[i - 1] >= w) {
                    K[i][w] = Math.min(wt[i - 1], K[i - 1][w]);
                }
                // compare using formula
                else {
                    if (K[i - 1][w] == 0 && w <= value_so_far)
                        K[i][w] = Math.max(wt[i - 1] + K[i - 1][w - val[i - 1]], K[i - 1][w]);
                    else K[i][w] = Math.min(wt[i - 1] + K[i - 1][w - val[i - 1]], K[i - 1][w]);
                }
            }
        }
        return K[n][W];
    }

    public static void main(String[] args) {
//        int[] wt = new int[]{200, 100, 30, 700, 250};
        int[] wt = new int[]{4122, 4106, 942, 7964, 8271, 4259, 5021, 5134, 6418, 3008, 1784, 5875, 2012, 5344, 6560};
        int[] val = new int[]{16, 13, 9, 23, 7, 35, 23, 11, 33, 23, 46, 38, 42, 44, 43};
        int W = 100;
        int n = val.length;
        System.out.println(sack(W, wt, val, n));
    }
} 