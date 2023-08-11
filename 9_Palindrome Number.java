class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(0<=x && x<= 9) return true;

        String s = x+"";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString().equals(s);
    }
}