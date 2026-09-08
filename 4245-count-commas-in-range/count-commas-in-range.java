class Solution {
    public int countCommas(int n) {
        int count = 0;
        for (int i = 1000; i <= n; i++) {
            count += getCommas(i);
        }

        return count;
    }

    public static int getCommas(int num) {
        if (num <= 999)
            return 0;
        return 1;
    }
}