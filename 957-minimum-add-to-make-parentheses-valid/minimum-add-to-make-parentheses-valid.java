class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (st.empty()) {
                st.push(c);
            } else {
                if (c == ')' && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(c);
                }
            }

            // System.out.println(st + " " + st.size());
        }
        return st.size();
    }
}