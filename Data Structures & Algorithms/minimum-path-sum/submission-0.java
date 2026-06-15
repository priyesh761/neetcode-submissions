class Solution {
    public int minPathSum(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                int val = Integer.MAX_VALUE;
                if(i!=0) {
                    val = Math.min(val, grid[i-1][j]+grid[i][j]);
                }
                if(j!=0) {
                    val = Math.min(val, grid[i][j-1]+grid[i][j]);
                }
                if(i==0&&j==0) val = grid[i][j];
                grid[i][j] = val;
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}