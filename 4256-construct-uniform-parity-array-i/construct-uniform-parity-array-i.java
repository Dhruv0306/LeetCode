class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int oddNum = 101;
        for (int i : nums1) {
            if (i % 2 == 1) {
                return true;
            }
        }

        return oddNum == 101;
    }
}