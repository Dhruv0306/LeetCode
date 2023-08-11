
class Solution {
    public boolean isMatch(String s, String p) {
        try{
            return java.util.regex.Pattern.matches(p,s);
        }catch(Exception e){
            return true;
        }
        
    }
}