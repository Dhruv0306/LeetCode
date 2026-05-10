class Solution {
    public int maximumJumps(int[] nums, int target) {
        int jump = 0, n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 0; i < n - 1; i++){
            if(dp[i] == -1) continue;
            int j = i + 1;
            while(j < n){
                if(-1 * target <= nums[j] - nums[i] && nums[j] - nums[i] <= target){
                    dp[j] = Math.max(dp[j] , dp[i] + 1);
                }
                j++;
            }
        }
        return (dp[n - 1] == 0) ? -1 : dp[n - 1];
    }

    public static int helper(int[] nums, int target, int ind, int jump, int n){
        if(ind >= n) return -1;
        if(ind == n - 1) {
            return jump;
        }

        int j = ind + 1;
        int jumps = 0;
        while(j < n){
            if(-1 * target <= nums[j] - nums[ind] && nums[j] - nums[ind] <= target){
                // System.out.println(ind + " " + j + " " + jumps);
                jumps = Math.max(helper(nums, target, j, jump + 1, n), jumps);
            }
            j++;
        }

        return (jumps == 0) ? -1 : jumps;
    }
}