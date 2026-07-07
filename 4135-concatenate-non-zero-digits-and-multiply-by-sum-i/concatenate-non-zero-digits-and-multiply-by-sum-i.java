class Solution {
    public long sumAndMultiply(int n) {
        long m = 0, mul = 1, sum = 0;
        while (n >= 1) {
            if (n % 10 > 0) {
                sum += n % 10;
                m += mul * (n % 10);
                mul *= 10;
            }
            n /= 10;
        }
        return sum * m;
    }
}