class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-","").toUpperCase();
        StringBuilder sb = new StringBuilder(s);
        int i = s.length() - k;
        while(i > 0){
            sb.insert(i, "-");
            i -= k;
        }
        return sb.toString();
    }
}