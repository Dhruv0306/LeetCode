class Solution {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i = 0; i < cost.length; i++) {
            pq.add(cost[i]);
        }
        
        int ans = 0;
        while (pq.size() > 0) {
            int a = pq.poll();
            int b = pq.size() > 0 ? pq.poll() : 0;
            int c = pq.size() > 0 ? pq.poll() : 0;
            ans += a + b;
        }
        return ans;
    }
}