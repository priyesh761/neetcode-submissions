class Solution {
    bool dfs(vector<vector<int>>& graph, vector<bool>& vis, int curr, int par) {
        if(vis[curr]) return false;
        vis[curr] = true;

        bool isValid = true;
        for(int i: graph[curr])
            if(i!=par)
                isValid = isValid && dfs(graph, vis, i, curr);
        
        return isValid;
    }
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n);
        for(auto& i: edges) {
            graph[i[0]].push_back(i[1]);
            graph[i[1]].push_back(i[0]);
        }

        vector<bool> vis(n);

        bool ans = dfs(graph, vis, 0, -1);
        for(auto i: vis) ans = ans && i;
        return ans;
    }
};
