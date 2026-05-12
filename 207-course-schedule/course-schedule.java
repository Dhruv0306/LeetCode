class Solution {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int[] state; 

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        state = new int[numCourses];

        for (int[] p : prerequisites) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }

        return true;
    }

    private boolean dfs(int node) {
        if (state[node] == 1) return false; 
        if (state[node] == 2) return true;  

        state[node] = 1;

        if (map.containsKey(node)) {
            for (int nei : map.get(node)) {
                if (!dfs(nei)) return false;
            }
        }

        state[node] = 2;
        return true;
    }
}