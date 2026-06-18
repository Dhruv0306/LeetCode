class Solution {
    public double angleClock(int hour, int minutes) {
        double h2m = ((hour + minutes/60.0) * 5) % 60;
        double m2d = minutes * 6.0;
        double h2m2d = h2m * 6.0;
        double angle1 = Math.abs(m2d - h2m2d);
        // System.out.println(angle1);
        return Math.min(angle1, 360 - angle1);
    }
}