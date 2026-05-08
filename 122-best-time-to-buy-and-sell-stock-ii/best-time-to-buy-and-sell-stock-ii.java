class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        dp[0][2] = 0;
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][1] = -1 * prices[i];
            dp[i][2] = dp[i][0] + prices[i] - prices[i - 1];
            System.out.println(dp[i][0] + " " + dp[i][1] + " " + dp[i][2]);
        }
        int i = n - 1;
    return Math.max(Math.max(dp[i][0], dp[i][1]), dp[i][2]);
    }
}