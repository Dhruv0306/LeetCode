class Solution {

    public int[] assignTasks(int[] servers, int[] tasks) {

        Queue<int[]> tasksQueue = new LinkedList<>();

        for (int i = 0; i < tasks.length; i++) {
            tasksQueue.add(new int[] { i, tasks[i] });
        }

        PriorityQueue<int[]> availableServers = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i = 0; i < servers.length; i++) {
            availableServers.add(new int[] { i, servers[i] });
        }

        PriorityQueue<int[]> cooldownQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[tasks.length];
        int time = 0;

        while (!tasksQueue.isEmpty()) {

            int[] task = tasksQueue.poll();

            time = Math.max(time, task[0]);

            while (!cooldownQueue.isEmpty() && time >= cooldownQueue.peek()[0]) {
                int[] serverDetails = cooldownQueue.poll();
                availableServers.add(new int[] { serverDetails[1], serverDetails[2] });
            }

            if (availableServers.isEmpty()) {
                time = cooldownQueue.peek()[0];
                while (!cooldownQueue.isEmpty() && time >= cooldownQueue.peek()[0]) {
                    int[] serverDetails = cooldownQueue.poll();
                    availableServers.add(new int[] { serverDetails[1], serverDetails[2] });
                }
            }

            int[] server = availableServers.poll();
            ans[task[0]] = server[0];
            int availableTime = time + task[1];
            cooldownQueue.add(new int[] { availableTime, server[0], server[1] });
        }
        return ans;
    }
}