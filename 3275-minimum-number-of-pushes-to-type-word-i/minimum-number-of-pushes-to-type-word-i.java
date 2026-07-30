class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        if (1 <= n && n <= 8) {
            return n;
        }

        if (9 <= n && n <= 16) {
            return 2 * n - 8;
        }

        if (17 <= n && n <= 24) {
            return 3 * n - 24;
        }

        if (25 <= n && n <= 26) {
            return 4 * n - 48;
        }

        return -1;
    }
}