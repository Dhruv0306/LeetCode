class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++){
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }

        int minCharCount = (map.get('b') == null) ? 0 : map.get('b');
        if(minCharCount == 0) return 0;
        char[] uniqBalloon = {'b', 'a', 'l', 'o', 'n'};
        for(char c : uniqBalloon) {
            if(c == 'l' || c == 'o'){
                minCharCount = Math.min(minCharCount, (map.get(c) == null) ? 0 : map.get(c)/2);
            } else {
                minCharCount = Math.min(minCharCount, (map.get(c) == null) ? 0 : map.get(c));   
            }
            if(minCharCount == 0) return minCharCount;
        }

        return minCharCount;
    }
}