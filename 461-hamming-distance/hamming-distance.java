class Solution {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        while(x > 0 || y > 0){
            int bitX = (x > 0) ? x % 2 : -1;
            int bitY = (y > 0) ? y % 2 : -1;
            System.out.println(bitX + " " + bitY + " " + x + " " + y);
            if(bitX == -1 && bitY == 1) distance++;
            if(bitX == 1 && bitY == -1) distance++;
            if(bitX != -1 && bitY != -1 && bitX != bitY) distance++;
            x >>= 1;
            y >>= 1;
            System.out.println( x + " " + y);

        }
        return distance;
    }
}