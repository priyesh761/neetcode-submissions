class Solution {
    int dfs(vector<vector<int>>& grid, vector<int>& vis, set<int>& res, int curr, int par=-1) {
        if(vis[curr]==true) return curr;
        vis[curr] = true;
        int nd=-1;
        for(int i:grid[curr]) {
            if(par==i) continue;
            int vl = dfs(grid, vis, res, i, curr);
            if(vl!=-1) {
                res.insert(curr);
                if(vl!=curr) nd=vl;
                break;
            }
        }
        return nd;
    }
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<vector<int>> grid(edges.size());
        for(auto& edge: edges) {
            grid[edge[0]-1].push_back(edge[1]-1);
            grid[edge[1]-1].push_back(edge[0]-1);
        }

        set<int> res;
        vector<int> vis(edges.size());
        dfs(grid, vis, res, 0);
        int ans=-1;
        for(int i=0; i<edges.size(); i++) {
            if(res.count(edges[i][0]-1)&&res.count(edges[i][1]-1)) ans=i;
        }
        return edges[ans];
    }
};
