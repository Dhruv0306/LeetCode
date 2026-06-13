class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        int[] wordWeaights = new int[n];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(String word: words){
            for(char c : word.toCharArray()){
                wordWeaights[i] += weights[c - 'a'] % 26;
            }
            wordWeaights[i] %= 26;
            sb.append((char) ((int)'z' - wordWeaights[i]));
            i++;
        }

        return sb.toString();
    }
}