class Solution {
    public boolean detectCapitalUse(String s) {
        int n = s.length();
        if(n <= 1){
            return true;
        }
        boolean isCapital = false;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(i == 0){
                if(Character.isUpperCase(c)){
                    if(Character.isUpperCase(s.charAt(i+1))){
                        isCapital = true;
                    }
                }
            }
            else{
                if(isCapital && Character.isLowerCase(c) || !isCapital && Character.isUpperCase(c)){
                    return false;
                }
            }
            
        }
        return true;
    }
}