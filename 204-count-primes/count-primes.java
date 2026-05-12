class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        if (n == 3)
            return 1;
        if (n <= 5)
            return 2;
        boolean[] isP = new boolean[n];
        Arrays.fill(isP, true);
        isP[1] = false;
        int i = 2;
        int count = 0;
        while (i < n) {
            if (isP[i]) {
                count++;
                int j = 2;
                while (j * i < n) {
                    isP[j * i] = false;
                    j++;
                }
            }
            i++;
        }
        return count;
    }
}