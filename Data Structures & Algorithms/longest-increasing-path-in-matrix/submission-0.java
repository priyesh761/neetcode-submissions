class Solution {
    int[][] dir = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };
    private int dfs(int[][] matrix, int[][] maxLen, int i, int j) {
        if(maxLen[i][j]!=0) return maxLen[i][j];
        int n = matrix.length;
        int m = matrix[0].length;
        maxLen[i][j] = 1;
        for(int[] dx: dir) {
            if(i+dx[0]>=0 && i+dx[0]<n && j+dx[1]>=0 && j+dx[1]<m) {
                if(matrix[i+dx[0]][j+dx[1]]>matrix[i][j]){
                    maxLen[i][j] = Math.max(maxLen[i][j], 1+dfs(matrix, maxLen, i+dx[0], j+dx[1]));
                }
            }
        }
        return maxLen[i][j];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] maxLen = new int[n][m];
        int mx = 1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                mx = Math.max(mx, dfs(matrix, maxLen, i, j));
            }
        }
        return mx;
    }
}
