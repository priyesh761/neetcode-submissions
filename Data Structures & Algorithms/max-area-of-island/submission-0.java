class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    private int calcArea(int[][] grid, int row, int column) {
        if(grid[row][column]==0) return 0;
        grid[row][column] = 0;
        
        int area = 1;
        for(int i=0;i<4;i++) {
            if(row+dx[i]>=0 && row+dx[i]<grid.length) {
                if(column+dy[i]>=0 && column+dy[i]<grid[0].length) {
                    area += calcArea(grid, row+dx[i], column+dy[i]);
                }
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int mx = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                mx = Math.max(mx, calcArea(grid, i, j));
            }
        }
        return mx;
    }
}
