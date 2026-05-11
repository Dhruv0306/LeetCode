class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for(int i = 5; i <= n; i += 5){
            count += countFactor5(i);
        }
        return count;
    }

    public static int countFactor5(int n){
        if(n % 5 != 0) return 0;
        int count = 0;
        while(n % 5 == 0) {
            count++;
            n /= 5;
        }
        return count;
    }    
}