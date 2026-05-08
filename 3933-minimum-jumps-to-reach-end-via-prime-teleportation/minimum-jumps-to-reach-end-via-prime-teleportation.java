import java.util.*;

class Solution {
    private static final int MAX_VAL = 1000001;
    private static boolean[] isPrime = new boolean[MAX_VAL];

    static {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p < MAX_VAL; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < MAX_VAL; i += p) isPrime[i] = false;
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            for (int p = 2; p * p <= val; p++) {
                if (val % p == 0) {
                    if (isPrime[p]) primeToIndices.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                    int other = val / p;
                    if (other != p && isPrime[other]) primeToIndices.computeIfAbsent(other, k -> new ArrayList<>()).add(i);
                }
            }
            if (isPrime[val]) primeToIndices.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Set<Integer> usedPrimes = new HashSet<>();

        queue.add(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == n - 1) return steps;

                int[] neighbors = {curr - 1, curr + 1};
                for (int next : neighbors) {
                    if (next >= 0 && next < n && !visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }

                int p = nums[curr];
                if (isPrime[p] && !usedPrimes.contains(p)) {
                    for (int targetIdx : primeToIndices.getOrDefault(p, Collections.emptyList())) {
                        if (!visited[targetIdx]) {
                            visited[targetIdx] = true;
                            queue.add(targetIdx);
                        }
                    }
                    usedPrimes.add(p);
                }
            }
            steps++;
        }
        return -1;
    }
}
