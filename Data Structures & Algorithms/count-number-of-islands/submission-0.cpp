class Solution {
    int dx[4] = {0,0,-1,1};
    int dy[4] = {-1,1,0,0};
    void markIsland(vector<vector<char>>& grid, vector<vector<bool>>& vis, int x, int y) {
        if(vis[x][y]) return;
        vis[x][y] = true;
        for(int i=0;i<4;i++) {
            int nx = x+dx[i], ny = y+dy[i];
            if(nx>=0 && nx<grid.size()) {
                if(ny>=0 && ny<grid[0].size()) {
                    if(grid[nx][ny]=='1' && vis[nx][ny]==false) {
                        markIsland(grid, vis, nx, ny);
                    }
                }
            }
        }
        
    }
public:
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<bool>> vis(grid.size(), vector<bool>(grid[0].size()));

        int cnt=0;
        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j]=='1' && vis[i][j]==false) {
                    markIsland(grid, vis, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
};
