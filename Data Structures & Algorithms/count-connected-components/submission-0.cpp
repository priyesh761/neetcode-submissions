class Solution {
    void markVisited(vector<vector<int>>& grid, vector<int>& vis, int ind) {
        vis[ind] = true;
        for(auto& node: grid[ind]) {
            if(vis[node]==false) {
                vis[node] = true;
                markVisited(grid, vis, node);
            }
        }
    }
public:
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n);
        for(auto& edge: edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }

        int cnt=0;
        vector<int> vis(n);
        for(int i=0;i<n;i++) {
            if(vis[i]) continue;
            markVisited(graph, vis, i);
            cnt++;
        }
        return cnt;
    }
};
