class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        Arrays.fill(dp[0][0], -1);
        dp[0][0][(grid[0][0] == 0) ? 0 : 1] = grid[0][0];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                Arrays.fill(dp[i][j], -1);
                int indI = Math.max(0, i - 1);
                int indJ = Math.max(0, j - 1);
                int currCost = (grid[i][j] == 0) ? 0 : 1;
                if(i - 1 >= 0 && j - 1 >= 0){
                    for(int c = 0; c <= k; c++){
                        if(c + currCost > k) break;
                        if(dp[indI][j][c] == -1 && dp[i][indJ][c] == -1) continue;
                        // System.out.println("i: " + i + " j: " + j + " c: " + c + " indI: " + indI + " indJ: " + indJ);
                        dp[i][j][c + currCost] = Math.max(dp[i][j][c + currCost], Math.max(dp[indI][j][c], dp[i][indJ][c]) + grid[i][j]);
                        // System.out.println("dp[i][j][c + currCost]: " + dp[i][j][c + currCost]);
                    }
                } else if(i - 1 >= 0){
                    for(int c = 0; c <= k; c++){
                        if(c + currCost > k) break;
                        if(dp[indI][j][c] == -1) continue;
                        // System.out.println("i: " + i + " j: " + j + " c: " + c + " indI: " + indI + " indJ: " + indJ);
                        dp[i][j][c + currCost] = Math.max(dp[i][j][c + currCost], dp[indI][j][c] + grid[i][j]);
                        // System.out.println("dp[i][j][c + currCost]: " + dp[i][j][c + currCost]);
                    }
                } else {
                    for(int c = 0; c <= k; c++){
                        if(c + currCost > k) break;
                        if(dp[i][indJ][c] == -1) continue;
                        // System.out.println("i: " + i + " j: " + j + " c: " + c + " indI: " + indI + " indJ: " + indJ);
                        dp[i][j][c + currCost] = Math.max(dp[i][j][c + currCost], dp[i][indJ][c] + grid[i][j]);
                        // System.out.println("dp[i][j][c + currCost]: " + dp[i][j][c + currCost]);
                    }
                }
            }
        }
        int maxScore = -1;
        for(int c = 0; c <= k; c++){
            maxScore = Math.max(maxScore, dp[m - 1][n - 1][c]);
        }

        return maxScore;
    }
}