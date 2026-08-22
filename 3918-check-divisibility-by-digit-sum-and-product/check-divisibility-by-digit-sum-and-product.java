class Solution {
    public boolean checkDivisibility(int n) {
        int sum = valuesSum(n);
        return n % sum == 0;
    }

    public static int valuesSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            product *= temp;
            sum += temp;
            n /= 10;
        }
        return product + sum;
    }
}