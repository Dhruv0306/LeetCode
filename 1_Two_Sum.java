class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=1;
        if(nums[i]+nums[j] == target) return new int[]{i,j};
        else if(nums[i]+nums[nums.length-1] == target) return new int[]{i,nums.length-1};
        else if(nums[nums.length-1] + nums[nums.length-2] == target) return new int[]{nums.length-1,nums.length-2};

        for(;i<=nums.length-2;i++){
            j=i+1;
            while(j<=nums.length-1){
                if(nums[i] + nums[j] == target)
                return new int[]{i,j};
                else 
                j++;
            }
        }
        return null;

    }
}