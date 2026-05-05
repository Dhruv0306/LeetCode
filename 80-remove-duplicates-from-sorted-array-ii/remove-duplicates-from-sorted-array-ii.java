class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int l = 2;
        int r = l;
        while (r < nums.length) {
            if (nums[r] == nums[l - 2]) {
                r++;
            } else {
                nums[l] = nums[r];
                l++;
                r++;
            }
        }
        return l;
    }
}