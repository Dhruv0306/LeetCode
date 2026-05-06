class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int seqLen = (1 << n);
        for(int i = 0; i < seqLen; i++){
            list.add(i ^ (i >> 1));
        }
        return list;
    }
}