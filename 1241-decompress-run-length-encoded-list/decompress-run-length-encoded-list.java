class Solution {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; 2 * i < n; i++) {
            int freq = nums[2 * i];
            int val = nums[2 * i + 1];
            while (freq-- > 0) {
                list.add(val);
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}