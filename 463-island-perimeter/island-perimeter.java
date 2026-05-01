class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j< grid[0].length ; j++){
                if(grid[i][j] == 1){
                    peri += 4;
                }
                // System.out.println("i: " + i + " j: " + j + " grid[i][j]: " + grid[i][j] + " peri: " + peri);
                if(i > 0 && grid[i][j] == 1 && grid[i - 1][j] == 1) peri--;
                // System.out.println("i: " + i + " j: " + j + " grid[i][j]: " + grid[i][j] + " peri: " + peri);
                if(i < grid.length - 1 && grid[i][j] == 1 && grid[i + 1][j] == 1) peri--;
                // System.out.println("i: " + i + " j: " + j + " grid[i][j]: " + grid[i][j] + " peri: " + peri);
                if(j > 0 && grid[i][j] == 1 && grid[i][j - 1] == 1) peri--;
                // System.out.println("i: " + i + " j: " + j + " grid[i][j]: " + grid[i][j] + " peri: " + peri);
                if(j < grid[0].length - 1 && grid[i][j] == 1 && grid[i][j + 1] == 1) peri--;
                // System.out.println("i: " + i + " j: " + j + " grid[i][j]: " + grid[i][j] + " peri: " + peri);
            }
        }
        return peri;
    }
}