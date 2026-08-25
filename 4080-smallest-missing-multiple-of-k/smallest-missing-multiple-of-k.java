class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int max = -1;
        for (int i : nums) {
            set.add(i);
            max = Math.max(i, max);
        }

        int i = 1;
        for (i = 1; i * k <= max; i++) {
            if (!set.contains(i * k))
                return i * k;
        }

        return i * k;
    }
}