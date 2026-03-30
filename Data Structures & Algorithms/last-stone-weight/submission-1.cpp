class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> pq;
        for(auto i: stones) {
            pq.push(i);
        }

        while(pq.size()>1) {
            int f = pq.top();
            pq.pop();
            int s = pq.top();
            pq.pop();
            if(f==s) continue;
            pq.push(abs(f-s));
        }

        return pq.empty() ? 0: pq.top();
    }
};
