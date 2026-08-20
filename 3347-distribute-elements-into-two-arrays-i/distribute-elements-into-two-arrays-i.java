class Solution {
    public int[] resultArray(int[] nums) {
        int len = nums.length, j = 1, k = 1;
        int[] nums1 = new int[len];
        int[] nums2 = new int[len];
        Arrays.fill(nums1, -1);
        Arrays.fill(nums2, -1);
        nums1[0] = nums[0];
        nums2[0] = nums[1];

        for (int i = 2; i < len; i++) {
            if (nums1[j - 1] > nums2[k - 1]) {
                nums1[j++] = nums[i];
            } else {
                nums2[k++] = nums[i];
            }
        }
        j = 0;
        for (int i : nums1) {
            if (i == -1)
                break;
            nums[j++] = i;
        }
        for (int i : nums2) {
            if (i == -1)
                break;
            nums[j++] = i;
        }

        return nums;
    }
}