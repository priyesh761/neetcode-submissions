class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    public int minimumEffortPath(int[][] heights) {
        Queue<int[]> pq = new PriorityQueue<>((a, b)-> a[2]-b[2]);
        int n = heights.length;
        int m = heights[0].length;
        int[][] vis = new int[n][m];
        for(int[] row: vis) {
            Arrays.fill(row, -1);
        }
        pq.add(new int[]{0,0,0});
        vis[0][0] = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.remove();

            for(int i=0;i<4;i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];
                if(x>=0&&x<n&&y>=0&&y<m) {
                    int diff = Math.abs(heights[curr[0]][curr[1]]-heights[x][y]);
                    int cost = Math.max(diff, curr[2]);
                    if(vis[x][y]==-1||vis[x][y]>cost) {
                        vis[x][y] = cost;
                        pq.add(new int[]{x, y, cost});
                    }
                }
            }
        }
        return vis[n-1][m-1];
    }
}