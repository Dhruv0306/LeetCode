class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // 1. Put all numbers in a Set for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxStreak = 0;

        for (int num : set) {
            // 2. Check if 'num' is the START of a sequence
            // (If set contains num - 1, then 'num' is NOT the start)
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 3. Count how long this sequence goes
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }

        return maxStreak;
    }
}
