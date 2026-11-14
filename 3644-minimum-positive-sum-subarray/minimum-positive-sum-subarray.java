class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size(), best = Integer.MAX_VALUE;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++)
            pre[i + 1] = pre[i] + nums.get(i);
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        for (int j = l; j <= n; j++) {
            starts.merge(pre[j - l], 1, Integer::sum);
            if (j > r)
                starts.compute(pre[j - r - 1], (key, c) -> c == 1 ? null : c - 1);
            Integer below = starts.lowerKey(pre[j]);
            if (below != null)
                best = Math.min(best, pre[j] - below);
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }
}