class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int increaseLen = 1, decreaseLen = 1, maxLen = 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                increaseLen += 1;
                decreaseLen = 1;
            } else if (nums[i] > nums[i + 1]) {
                increaseLen = 1;
                decreaseLen += 1;
            } else {
                increaseLen = 1;
                decreaseLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(increaseLen, decreaseLen));
        }

        return maxLen;
    }
}