class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if(word.equals(word.toUpperCase())) return true;
        if(word.equals(word.toLowerCase())) return true;
        if(Character.isLowerCase(word.charAt(0))) return false;
        for(int i = 1; i < n; i++){
            if(Character.isUpperCase(word.charAt(i))) return false;
        }

        return true;
    }
}