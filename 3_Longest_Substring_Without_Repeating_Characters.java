class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == "" || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int maxLength = 1;
        int right=1,left=0;
        for(;right<s.length(); right++){
            int c = s.indexOf(s.charAt(right),left);
            if(c >= left && c < right) left = c+1;
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}