class Solution {
    public void setZeroes(int[][] mat) {
        Set<Integer> cols = new HashSet<>(), rows = new HashSet<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    cols.add(j);
                    rows.add(i);
                }
            }
        }

        for (int i : cols){
            int k = 0;
            while (k < m){
                mat[k][i] = 0;
                k++;
            }
        }

        for (int i : rows){
            int k = 0;
            while (k < n){
                mat[i][k] = 0;
                k++;
            }
        }
    }
}