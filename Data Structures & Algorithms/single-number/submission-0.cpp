class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int uq=0;
        for(auto i: nums) {
            uq ^= i;
        }
        return uq;
    }
};
