class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> grid(numCourses);
        vector<int> indegree(numCourses);
        queue<int> qu;

        for(auto& i: prerequisites) {
            grid[i[1]].push_back(i[0]);
            indegree[i[0]]++;
        }
        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0) qu.push(i);
        }

        vector<int> res;
        while(!qu.empty()) {
            int course = qu.front();
            res.push_back(course);
            qu.pop();

            for(int i: grid[course]) {
                indegree[i]--;
                if(indegree[i]==0) {
                    qu.push(i);
                }
            }
        }
        return res.size() == numCourses ? res : vector<int>();
    }
};
