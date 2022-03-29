class StockSpanPrices {
    public static int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;

        int n = prices.length;

        int[] arr = new int[n];

        int minSoFar = Math.min(prices[0], prices[1]);
        int maxProfit = prices[1] - prices[0];

        for (int i = 1; i < n; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            arr[i - 1] = maxProfit;
            minSoFar = Math.min(prices[i], minSoFar);
        }
        return Math.max(arr[n - 2], 0);
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr));
    }
}