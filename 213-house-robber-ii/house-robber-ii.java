class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int rob1 = 0;
        int norob1 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int newRob = norob1 + nums[i];
            int newNoRob = Math.max(norob1, rob1);
            rob1 = newRob;
            norob1 = newNoRob;
        }
        int max1 = Math.max(rob1, norob1);

        int rob2 = 0;
        int norob2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int newRob = norob2 + nums[i];
            int newNoRob = Math.max(norob2, rob2);
            rob2 = newRob;
            norob2 = newNoRob;
        }
        int max2 = Math.max(rob2, norob2);

        return Math.max(max1, max2);
    }
}