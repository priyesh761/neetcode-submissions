class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](vector<int>& a, vector<int>& b){
            if(a[1]==b[1]) return a[0]<b[0];
            return a[1]<b[1];
        });
     
        int i=0, cnt=0;
        while(i<intervals.size()) {
            int j=i;
            while(i<intervals.size() && intervals[i][0]<intervals[j][1]) i++;
            cnt++;
        }
        return intervals.size()-cnt;
    }
};
