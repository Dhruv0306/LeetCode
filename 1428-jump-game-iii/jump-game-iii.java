class Solution {
    public boolean canReach(int[] arr, int start) {
        int N = arr.length;
        boolean[] visited = new boolean[N];
        boolean[] dp = new boolean[N];
        return dfs(arr, visited, start, dp);
    }

    public boolean dfs(int[] arr, boolean[] visited, int index, boolean[] dp) {

        visited[index] = true;

        if (arr[index] == 0) {
            dp[index] = true;
            return dp[index];
        }
        int left = index - arr[index];
        int right = index + arr[index];

        boolean leftval = left >= 0 && !visited[left] && dfs(arr, visited, left, dp);
        boolean rightval = right < arr.length && !visited[right] && dfs(arr, visited, right, dp);

        dp[index] = leftval || rightval;

        return dp[index];
    }
}