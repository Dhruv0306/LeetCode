class Solution {
    public void sortColors(int[] nums) {
        if (nums.length < 2)
            return;
        else {
            int[] ar = new int[3];
            for (int i = 0; i < nums.length; i++) {
                ar[nums[i]]++;
            }
            int j = 0;
            for (int i = 0; i < ar.length; i++) {
                while (ar[i]-- > 0) {
                    nums[j++] = i;
                }
            }
        }
    }
}