class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        if (n == 2)
            return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int i = 0;
        int[] ans = new int[2];
        for (int j : nums) {
            if (map.get(j) > 1)
                continue;
            ans[i++] = j;
            if (i >= 2)
                return ans;
        }
        return ans;
    }
}