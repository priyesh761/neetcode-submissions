/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        map<int,int> mp;
        for(auto& interval: intervals) {
            mp[interval.start]++;
            mp[interval.end]--;
        }
        int cnt=0, mx=0;
        for(auto& i: mp) {
            cnt+=i.second;
            mx = max(mx, cnt);
        }
        return mx;
    }
};
