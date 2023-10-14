class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int mid = Math.min(height[left], height[right]);
            ans = Math.max(ans, mid * (right - left));
            while (left < right && height[left] <= mid) {
                left++;
            }
            while (left < right && height[right] <= mid) {
                right--;
            }
        }
        return ans;
    }
}