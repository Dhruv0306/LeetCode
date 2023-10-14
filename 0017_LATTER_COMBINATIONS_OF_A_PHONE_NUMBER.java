class Solution {
    List<String> ans = new ArrayList<String>();
    String[] in;
    public List<String> letterCombinations(String digits) {
        in = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        fn(0, digits, new StringBuilder());
        return ans;
    }
    private void fn(int ind, String digits, StringBuilder str) {
        if(ind == digits.length()) {
            if(str.length() != 0)
                ans.add(str.toString());
            return;
        }
        String chars = in[digits.charAt(ind) - '0'];
        for(int i = 0; i < chars.length(); i++) {
            str.append(chars.charAt(i));
            fn(ind+1, digits, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}