class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansList = new ArrayList<>();
        int currRow = 1;
        while (currRow <= numRows) {
            List<Integer> currList = new ArrayList<>(currRow);
            currList.add(1);
            if (currRow == 1) {
                ansList.add(currList);
            } else if (currRow == 2) {
                currList.add(1);
                ansList.add(currList);
            } else {
                int maxInd = currRow - 1;
                List<Integer> prevRow = ansList.get(currRow - 2);
                for (int i = 1; i < maxInd; i++) {
                    currList.add(i, prevRow.get(i) + prevRow.get(i - 1));
                }
                currList.add(1);
                ansList.add(currList);
            }
            currRow++;
        }
        return ansList;
    }
}