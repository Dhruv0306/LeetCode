class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char original = word.charAt(i);
            char key = Character.toLowerCase(original);

            map.putIfAbsent(key, new int[]{-1, Integer.MAX_VALUE});

            int[] inds = map.get(key);

            if (Character.isLowerCase(original)) {
                inds[0] = i;
            } else {
                inds[1] = Math.min(inds[1], i);
            }
        }

        int count = 0;

        for (int[] inds : map.values()) {
            if (inds[0] != -1 && inds[1] != Integer.MAX_VALUE && inds[0] < inds[1]) {
                count++;
            }
        }

        return count;
    }
}