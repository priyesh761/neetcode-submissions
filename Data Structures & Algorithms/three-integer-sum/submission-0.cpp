class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        vector<vector<int>> res;
        int i=0;
        while(i<nums.size()-2) {
            int j=i+1, k=nums.size()-1;
            while(j<k) {
                if(nums[j]+nums[k]<-1*nums[i]) {
                    do j++; while(j<k && nums[j]==nums[j-1]);
                } else if(nums[j]+nums[k]>-1*nums[i]) {
                    do k--; while(j<k && nums[k]==nums[k+1]);
                } else {
                    res.push_back({nums[i], nums[j], nums[k]});
                    do j++; while(j<k && nums[j]==nums[j-1]);
                    do k--; while(j<k && nums[k]==nums[k+1]);
                }
            }
            do i++; while(i<nums.size()&& nums[i]==nums[i-1]);
        }
        return res;
    }
};
