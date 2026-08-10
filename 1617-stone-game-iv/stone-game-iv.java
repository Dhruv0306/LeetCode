class Solution {
    public boolean winnerSquareGame(int n) {
        if (n == 1)
            return true;
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
            // System.out.printf("dp[%d]: %b\n", i, dp[i]);
        }
        return dp[n];
    }
}