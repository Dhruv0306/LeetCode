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
                sb.append(s.substring(i + k));
                break;
            } else {
                for(int j = n - 1; j >= i; j--){
                    sb.append(s.charAt(j));
                }
                break;
            }
        }
        return sb.toString();
    }
}