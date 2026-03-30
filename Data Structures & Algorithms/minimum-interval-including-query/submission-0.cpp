class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        auto comp = [](vector<int>& a, vector<int>& b) { return a[1]-a[0] < b[1]-b[0]; };
        sort(intervals.begin(), intervals.end(), comp);

        vector<int> ar(10000, -1);
        for(int i=0;i<intervals.size(); i++){
            for(int j=intervals[i][0];j<=intervals[i][1];j++) {
                if(ar[j]==-1) ar[j]=i;
                else {
                    j = intervals[ar[j]][1];
                }
            }
        }

        vector<int> res;
        for(auto i: queries) {
            if(ar[i]==-1) res.push_back(-1);
            else res.push_back(intervals[ar[i]][1]-intervals[ar[i]][0]+1);
        }
        return res;
    }
};
