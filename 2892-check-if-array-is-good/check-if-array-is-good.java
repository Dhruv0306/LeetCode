class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return false;
        
        int[] freq = new int[n + 1];
        for(int i : nums){
            if(i > n) return false;
            freq[i]++;
        }

        for(int i = 1; i <= n - 1; i++){
            // System.out.println(i + " " + freq[i]);
            if(i < n - 1 && freq[i] < 1) return false;
            if(i == n - 1 && freq[i] < 2) return false;
        }

        return true;
    }
}