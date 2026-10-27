class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m, minY = n, lOPS = ops.length;
        if (lOPS == 0)
            return m * n;
        for (int i = 0; i < lOPS; i++) {
            minX = Math.min(minX, ops[i][0]);
            minY = Math.min(minY, ops[i][1]);
        }
        return minX * minY;
    }
}