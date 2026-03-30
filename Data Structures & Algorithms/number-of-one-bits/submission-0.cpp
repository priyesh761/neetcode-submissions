class Solution {
public:
    int hammingWeight(uint32_t n) {
        int cnt=0;
        unsigned int mask=1;
        for(int i=0; i<32;i++) {
            cnt += (((mask<<i) & n) !=0 ? 1: 0);
        }
        return cnt;
    }
};
