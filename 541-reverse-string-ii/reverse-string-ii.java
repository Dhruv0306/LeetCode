class Solution {
    public String reverseStr(String s, int k) {
        int i = 0, n = s.length();
        StringBuilder sb = new StringBuilder();
        while(i < n){
            if((n - i) > 2 * k){
                for(int j = i + k - 1; j >= i; j--){
                    sb.append(s.charAt(j));
                }
                for(int j = i + k; j < (i + 2 * k); j++){
                    sb.append(s.charAt(j));
                }
                i += 2 * k;
            } else if((n - i) >= k){
                for(int j = i + k - 1; j >= i; j--){
                    sb.append(s.charAt(j));
                }
                // s = reverseBetween(s, i, i + k - 1);
                sb.append(s.substring(i + k));
                break;
            } else {
                // s = reverseBetween(s, i, n - 1);
                for(int j = n - 1; j >= i; j--){
                    sb.append(s.charAt(j));
                }
                // sb.append(s.substring(i, n));
                break;
            }
        }
        return sb.toString();
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