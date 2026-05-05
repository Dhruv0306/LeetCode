class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, n = nums.length;
        int distinct = 0;
        while(i < n){
            if(i < n - 1 && nums[i] == nums[i + 1]){
                nums[distinct++] = nums[i++];
                nums[distinct++] = nums[i++];
                while(i < n && nums[i] == nums[i - 1]) i++;
                // System.out.println(i + " 1");
            } else if(i < n - 1 && nums[i] != nums[i + 1]){
                nums[distinct++] = nums[i++];
                // System.out.println(i + " 2");
            } else {
                nums[distinct++] = nums[i++];
            }
            // System.out.println(i);
        }
        return distinct;
    }
}