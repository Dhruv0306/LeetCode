class Solution {
    public int numberOfSpecialChars(String word) {
        int [] upperFirst = new int [26];
        int [] lowerLast = new int [26];

        Arrays.fill(lowerLast, -1);
        Arrays.fill(upperFirst, -1);

        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                lowerLast[ch-'a'] = i;
            }
            else{
                int idx = ch-'A';
                if(upperFirst[idx]==-1){
                    upperFirst[idx] = i;
                }
            }
        }
        int count = 0;
        for(int i =0;i<26;i++){
            if(
                lowerLast[i] != -1 && 
                upperFirst[i] != -1 &&
                lowerLast[i]<upperFirst[i]
                ){
                    count++;
                }
        }
        return count;
    }
}