class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        if (1 <= n && n <= 8) {
            System.out.println(1);
            return n;
        }

        if (9 <= n && n <= 16) {
            // System.out.println(2);
            return 2 * n - 8;
        }

        if (17 <= n && n <= 24) {
            // System.out.println(3);
            return 3 * n - 24;
        }

        if (25 <= n && n <= 26) {
            // System.out.println(4);
            return 4 * n - 48;
        }

        return -1;
    }
}