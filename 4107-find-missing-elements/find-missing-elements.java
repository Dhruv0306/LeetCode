class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int min = nums[0], max = nums[n - 1];
        int i = 0;
        while (i < n && min <= max) {
            if (min == nums[i])
                i++;
            else
                ans.add(min);

            min++;
        }

        return ans;
    }
}