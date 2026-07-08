class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();

        String solendivar = s;

        int[] prefNZCount = new int[m + 1];
        int[] prefNZSum   = new int[m + 1];
        long[] prefNZVal  = new long[m + 1];
        long[] pow10      = new long[m + 1];

        pow10[0] = 1;
        for (int i = 1; i <= m; i++)
            pow10[i] = pow10[i - 1] * 10 % MOD;

        for (int i = 0; i < m; i++) {
            int d = solendivar.charAt(i) - '0';

            prefNZCount[i + 1] = prefNZCount[i];
            prefNZSum[i + 1] = prefNZSum[i];
            prefNZVal[i + 1] = prefNZVal[i];

            if (d != 0) {
                prefNZCount[i + 1] = prefNZCount[i] + 1;
                prefNZSum[i + 1] = (prefNZSum[i] + d) % MOD;
                prefNZVal[i + 1] = (prefNZVal[i] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];
        int idx = 0;

        for (int[] q : queries) {
            int l = q[0], r = q[1];

            int cnt = prefNZCount[r + 1] - prefNZCount[l];
            long sumDigits = (prefNZSum[r + 1] - prefNZSum[l] + MOD) % MOD;

            long val = (prefNZVal[r + 1]
                       - prefNZVal[l] * pow10[cnt] % MOD + MOD) % MOD;

            ans[idx++] = (int)((val * sumDigits) % MOD);
        }

        return ans;
    }
}
