class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        long m = mass;
        for (int i = 0; i < n; i++) {
            // System.out.println(asteroids[i] + " " + m);
            if (asteroids[i] <= m) {
                m += asteroids[i];
            } else {
                return false;
            }
        }
        return true;
    }
}