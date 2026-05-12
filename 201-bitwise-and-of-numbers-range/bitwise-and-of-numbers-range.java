class Solution {
    public int rangeBitwiseAnd(int l, int r) {
        if (l == r)
            return l;
        int ans = 0;
        int maxSetBit = (int) (Math.log(r) / Math.log(2));

        for (int bit = maxSetBit; bit >= 0; bit--) {
            int andWithR = (r & (1 << bit));
            int andWithL = (l & (1 << bit));

            if (andWithR > 0 && andWithL > 0) {

                ans = ans | (1 << bit);
            }

            else if (andWithR > 0 || andWithL > 0)
                break;
        }

        return ans;
    }
}