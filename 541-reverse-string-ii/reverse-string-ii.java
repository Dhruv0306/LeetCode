class Solution {
    public String reverseStr(String s, int k) {
        int i = 0, n = s.length();
        while(i < n){
            if((n - i) > 2 * k){
                s = reverseBetween(s, i, i + k - 1);
                i += 2 * k;
            } else if((n - i) >= k){
                s = reverseBetween(s, i, i + k - 1);
                break;
            } else {
                s = reverseBetween(s, i, n - 1);
                break;
            }
        }
        return s;
    }

    public static String reverseBetween(String s, int start, int end){
        if(start < 0 || end < 0) return "-1";
        if(start > s.length() || end > s.length()) return "-1";
        if(start > end) return "-1";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < start; i++){
            sb.append(s.charAt(i));
        }
        for(int i = end; i >= start; i--){
            sb.append(s.charAt(i));
        }

        for(int i = end + 1; i < s.length(); i++){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}