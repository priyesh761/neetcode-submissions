class Solution {
public:
    void islandsAndTreasure(vector<vector<int>>& grid) {
        vector<vector<bool>> vis(grid.size(), vector<bool>(grid[0].size()));

        queue<vector<int>> qu;

        for(int i=0;i<grid.size(); i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j]==0) qu.push({i,j, 0});
            }
        }

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        while(!qu.empty()) {
            vector<int> cordinate = qu.front();
            qu.pop();
            int x=cordinate[0], y = cordinate[1], dist=cordinate[2]; 
            for(int i=0;i<4;i++)
                if(x+dx[i]>=0 && x+dx[i]<grid.size())
                    if(y+dy[i]>=0 && y+dy[i]<grid[0].size())
                        if(grid[x+dx[i]][y+dy[i]]==INT_MAX) {
                            grid[x+dx[i]][y+dy[i]] = dist +1;
                            qu.push({x+dx[i], y+dy[i], dist+1});
                        }
        }
    }
};
