class Solution {
    vector<pair<int,int>> getNeighbors(int x, int y, int n, int m) {
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        vector<pair<int,int>> neighbors;

        for(int i=0;i<4;i++)
            if(x+dx[i]>=0 && x+dx[i]<n)
                if(y+dy[i]>=0 && y+dy[i]<m)
                    neighbors.push_back(make_pair(x+dx[i], y+dy[i]));

        return neighbors;
    }

    pair<bool, bool> dfs(vector<vector<int>>& heights,
        vector<vector<pair<int, int>>>& hasWay,
        int x,
        int y) {
            if(hasWay[x][y].first!=-1 && hasWay[x][y].second!=-1) return hasWay[x][y];
            int n = heights.size();
            int m = heights[0].size();

            vector<pair<int,int>> neighbors = getNeighbors(x,y,n,m);
            hasWay[x][y].first = (x==0||y==0)?1:0;
            hasWay[x][y].second = (x==n-1||y==m-1)?1:0;
            for(auto &pos: neighbors){
                if(heights[x][y]>=heights[pos.first][pos.second]) {
                    pair<int,int> tempAns = dfs(heights, hasWay, pos.first, pos.second);
                    if(hasWay[x][y].first!=1) hasWay[x][y].first = tempAns.first;
                    if(hasWay[x][y].second!=1) hasWay[x][y].second = tempAns.second;
                }
            }
            return hasWay[x][y];
        }
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int n = heights.size();
        int m = heights[0].size();
        vector<vector<pair<int, int>>> hasWay(n, vector<pair<int,int>>(m, make_pair(-1, -1)));

        vector<vector<int>> ans;

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++) {
                dfs(heights, hasWay, i, j);
                if(hasWay[i][j].first==1 && hasWay[i][j].second==1) {
                    ans.push_back({i,j});
                }
            }
        return ans;
    }
};
