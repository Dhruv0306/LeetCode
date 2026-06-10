class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        while (num1 <= num2) {
            if(num1 > 100) count += getWaviness(String.valueOf(num1));
            num1++;
        }
        return count;
    }

    public static int getWaviness(String num) {
        int n = num.length();
        if (n < 3)
            return 0;
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            char l = num.charAt(i - 1);
            char c = num.charAt(i);
            char r = num.charAt(i + 1);

            if (c > l && c > r)
                count++;
            else if (c < l && c < r)
                count++;
        }
        return count;
    }
}