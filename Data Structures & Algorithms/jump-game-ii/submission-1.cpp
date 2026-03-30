class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size()==1) return 0;
        int mx=0, cs=0, nxtMx=0;
        for(int i=0;i<nums.size();i++) {
            if(i>mx) {
                cs++;
                mx = nxtMx;
            }
            nxtMx = max(nxtMx, i+nums[i]);
            if(nxtMx>=nums.size()-1) return cs+1;
        }
        return -1;
    }
};
