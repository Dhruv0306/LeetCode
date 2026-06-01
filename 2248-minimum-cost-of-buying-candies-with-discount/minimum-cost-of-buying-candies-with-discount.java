class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int n = cost.length;
        for (int i = n - 1; i >= 0; i--) {
            sum += cost[i] + ((i > 0) ? cost[i - 1] : 0);
            i--;
            i--;
        }

        return sum;
    }
}