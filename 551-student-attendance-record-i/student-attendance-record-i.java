class Solution {
    public boolean checkRecord(String s) {
        int A = 0, L = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == 'A'){
                A++;
                L = 0;
                if(A >= 2) return false;
            } else if(c == 'L'){
                L++;
                if(L >= 3) return false;
            } else {
                L = 0;
            }
        }

        return (L < 3);
    }
}