class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> finalList = new ArrayList<>();
        generate("(", 1, 0, n, finalList);
        return finalList;
    }

    public static void generate(String current, int oCount, int cCount, int n, List<String> list){
        if(current.length() == 2*n){
            list.add(current);
            return;
        }

        if(oCount < n)generate(current + "(", oCount + 1, cCount, n, list);
        if(cCount < oCount)generate(current + ")", oCount, cCount + 1, n, list);
    }
}