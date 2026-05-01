class Solution {
    public int countSegments(String s) {
        s = s.trim();
        if(s == null || s.isEmpty() || s == "") return 0;
        int i = 0, n = s.length();
        String[] ss = s.split(" ");
        int count = 0;
        for(String sss : ss){
            if(sss != null && !sss.isEmpty() && sss != "") count++;
        }
        return count;
    }
}