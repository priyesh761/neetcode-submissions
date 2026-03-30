class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        auto cmp = [](vector<int>& a, vector<int>& b){
            int a1 = abs(a[0]), a2 = abs(a[1]), b1=abs(b[0]), b2 = abs(b[1]);
            if(a1+a2==b1+b2) return max(a1,a2)<max(b1,b2);
            return a1+a2<b1+b2;
        };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq;

        for(auto& i: points){
            pq.push(i);
            if(pq.size()>k) pq.pop();
        }
        vector<vector<int>> res;
        while(!pq.empty()) {
            res.push_back(pq.top());
            pq.pop();
        }
        return res;
    }
};
