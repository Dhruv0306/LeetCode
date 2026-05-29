class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;

        // Method 1: 1ms + 44.95 MB
        int minSum = sumOfDigits(nums[0]);
        for (int i = 1; i < n; i++) {
            minSum = Math.min(minSum, sumOfDigits(nums[i]));
        }
        return minSum;
    }

    public int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}