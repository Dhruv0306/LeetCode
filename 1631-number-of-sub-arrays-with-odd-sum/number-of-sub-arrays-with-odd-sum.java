class Solution {
    static int mod = 1000000007;

    public int numOfSubarrays(int[] arr) {
        long[] temp = { 1, 0 };
        int val = 0, n = arr.length;
        long result = 0;
        for (int i = 0; i <= n - 1; i++) {
            val = ((val + arr[i]) % 2 + 2) % 2;

            temp[val]++;
        }
        result = (temp[0] * temp[1]) % mod;
        return (int) (result);
    }
}