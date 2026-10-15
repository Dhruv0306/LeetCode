class Solution {
    public int sumCounts(List<Integer> nums) {
        int len = nums.size(), ans = 0;
        if (len == 1) {
            return 1;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = nums.get(i);
        }
        for (int i = 1; i <= len; i++) {
            int temp = findDistinctCount(arr, i);
            ans += temp;
        }
        return ans;
    }

    public static int findDistinctCount(int[] arr, int k) {
        int ans = 0;
        for (int x = 0; x <= arr.length - k; x++) {
            int distinct = 0;
            for (int i = x; i < x + k; i++) {
                distinct++;
                for (int j = x; j < i; j++) {
                    if (arr[i] == arr[j]) {
                        distinct--;
                        break;
                    }
                }
            }

            ans += distinct * distinct;
        }
        return ans;
    }
}