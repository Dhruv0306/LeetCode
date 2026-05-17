class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if (arr[start] == 0)
            return true;
        if (start - arr[start] >= 0 && arr[start - arr[start]] == 0)
            return true;
        if (start + arr[start] < n && arr[start + arr[start]] == 0)
            return true;
        Queue<Integer> inds = new LinkedList<>();
        boolean[] visited = new boolean[n];
        inds.add(start);
        while (!inds.isEmpty()) {
            int ind = inds.poll();
            if (visited[ind])
                continue;
            if (arr[ind] == 0)
                return true;
            if (ind - arr[ind] >= 0)
                inds.add(ind - arr[ind]);
            if (ind + arr[ind] < n)
                inds.add(ind + arr[ind]);
            visited[ind] = true;
        }

        return false;
    }
}