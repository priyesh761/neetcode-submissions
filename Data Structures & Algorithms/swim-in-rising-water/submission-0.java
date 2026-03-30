class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b)-> { return a[2]-b[2];});

        pq.add(new int[]{0,0,grid[0][0]});
        vis[0][0] = true;
        while(!pq.isEmpty()) {
            int[] top = pq.remove();
            if(top[0]==n-1 && top[1]==m-1) return top[2];

            for(int i=0;i<4;i++) {
                int nx = top[0]+dx[i];
                int ny = top[1]+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !vis[nx][ny]) {
                    pq.add(new int[]{nx, ny, Math.max(grid[nx][ny], top[2])});
                    vis[nx][ny] = true;
                }
            }
        }  
        return -1;
    }
}
