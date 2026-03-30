class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<char, int> mp;
        map<int, unordered_set<char>> to;
        for (auto i: tasks) {
            mp[i]++;
        }
        priority_queue<pair<int,char>> pq;
        for(auto i: mp) {
            pq.push({i.second, i.first});
        }

        int t=0;
        while(!pq.empty()||!to.empty()) {
            t++;
            if(!pq.empty()) {
                int cnt;
                char c;
                tie(cnt, c) = pq.top();
                pq.pop();
                cnt--;
                if(cnt>0) {
                    if(!to.count(t+n)) to[t+n] = unordered_set<char>();
                    to[t+n].insert(c);
                    mp[c]=cnt;
                }
            }
            auto it = to.begin();
            while(it!=to.end() && it->first<=t) {
                for(char i: it->second) {
                    pq.push({mp[i], i});
                }
                it++;
            }
            to.erase(to.begin(), it);
        }
        return t;
    }
};
