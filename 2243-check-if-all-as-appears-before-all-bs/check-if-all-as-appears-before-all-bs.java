class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == 'a') {
            i++;
        }

        if (i == n)
            return true;

        while (i < n && s.charAt(i) == 'b') {
            i++;
        }

        return i >= n;
    }
}