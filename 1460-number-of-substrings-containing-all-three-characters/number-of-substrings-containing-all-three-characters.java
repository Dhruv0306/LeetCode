class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0, right = 0, aCount = 0, bCount = 0, cCount = 0;
        int ans = 0;
        
        if(s.charAt(right) == 'a') aCount++;
        else if(s.charAt(right) == 'b') bCount++;
        else cCount++;

        while(left < n && right < n){
            // System.out.println(left+ " " + right + " " + aCount + " " + bCount + " " + cCount);
            if(aCount >= 1 && bCount >= 1 && cCount >= 1){
                ans += n - right;
                if(s.charAt(left) == 'a') aCount--;
                else if(s.charAt(left) == 'b') bCount--;
                else cCount--;
                left++;
            }else{
                right++;
                if(right < n) {
                    if(s.charAt(right) == 'a') aCount++;
                    else if(s.charAt(right) == 'b') bCount++;
                    else cCount++;
                }
            }
        }

        return ans;
    }

    private static void increment(char s, int aCount, int bCount, int cCount){
        
    }

    private static void decrement(char s, int aCount, int bCount, int cCount){
        
    }
}