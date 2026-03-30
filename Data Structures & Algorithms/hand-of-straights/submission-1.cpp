class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        map<int,int> mp;
        for(int i: hand) {
            mp[i]++;
        }
        while(!mp.empty()) {
            int key = mp.begin()->first;
            int vl = mp.begin()->second;
            for(int i=key;i<key+groupSize;i++) {
                int nvl = mp[i];
                if(nvl<vl) return false;
                mp[i]-=vl;
                if(mp[i]==0) mp.erase(i);
            }
        }
        return true;
    }
};
