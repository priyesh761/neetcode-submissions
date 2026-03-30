class CountSquares {
    unordered_map<int, unordered_set<int>> xMp;
    map<pair<int,int>, int> cnt;
public:
    CountSquares() {
        
    }
    
    void add(vector<int> point) {
        cnt[{point[0], point[1]}]++;
        if(xMp.count(point[0])==false) {
            xMp[point[0]] = unordered_set<int>();
        }
        xMp[point[0]].insert(point[1]);
    }
    
    int count(vector<int> point) {
        int cntr=0;

        for(auto& i: xMp[point[0]]) {
            if(i==point[1]) continue;
            int d = abs(point[1]-i);
            if(cnt.count({point[0]+d, point[1]}) && cnt.count({point[0]+d, i})){
                cntr+= cnt[{point[0], i}] * cnt[{point[0]+d, point[1]}] * cnt[{point[0]+d, i}];
            }
            if(cnt.count({point[0]-d, point[1]}) && cnt.count({point[0]-d, i})){
                cntr += (cnt[{point[0], i}] * cnt[{point[0]-d, point[1]}] * cnt[{point[0]-d, i}]);
            }
        }
        return cntr;
    }
};
