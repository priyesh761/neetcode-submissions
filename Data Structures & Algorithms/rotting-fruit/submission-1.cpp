class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int cntF=0;
        queue<tuple<int,int, int>> qu;

        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j]==2) qu.push({i,j,0});
                if(grid[i][j]==1) cntF++;
            }
        }

        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};
        int mx=0;
        while(!qu.empty()) {
            int x,y,t;
            tie(x,y,t) = qu.front();
            mx = max(mx, t);
            qu.pop();
            for(int i=0;i<4;i++) {
                if(x+dx[i]>=0 && x+dx[i]<grid.size()) {
                    if(y+dy[i]>=0 && y+dy[i]<grid[0].size()) {
                        int nx = x+dx[i], ny = y+dy[i];
                        if(grid[nx][ny]!=1) continue;
                        cntF--;
                        qu.push({nx, ny, t+1});
                        grid[nx][ny] = 2;
                    }
                }
            }
        }
        return cntF==0 ? mx: -1;
    }
};
