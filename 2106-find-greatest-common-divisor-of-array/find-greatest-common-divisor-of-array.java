class Solution {
    public int findGCD(int[] nums) {
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            mn = Math.min(nums[i], mn);
            mx = Math.max(nums[i], mx);
        }

        for (int i = mn; i > 0; i--) {
            if (mx % i == 0 && mn % i == 0)
                return i;
        }
        return -1;
    }
}