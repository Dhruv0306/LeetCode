class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 1){
            return false;
        }

        int sq = (int) Math.sqrt(num);
        int ans = 0;

        for(int i = 1; i <= sq; i++){
            int a = num % i;
            int b = num / i;
            if(a == 0){
                ans += i;
                if(b != i && b != num){
                    ans += b;
                }
            }
        }
        return num==ans;
    }
}