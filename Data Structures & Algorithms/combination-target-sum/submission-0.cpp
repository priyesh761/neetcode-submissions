class Solution {
    void calc(vector<int>& nums, vector<vector<int>>& res, vector<int>& ans, int target, int ind) {
        if(target==0) {
            res.push_back(ans);
            return;
        }
        if(ind>=nums.size()) return;
        
        calc(nums, res, ans, target, ind+1);
        int i=1;
        while(i*nums[ind]<=target) {
            ans.push_back(nums[ind]);
            calc(nums, res, ans, target-i*nums[ind], ind+1);
            i++;
        }
        while(i>1) {
            ans.pop_back();
            i--;
        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        vector<vector<int>> res;
        vector<int> ans;
        calc(nums, res, ans, target, 0);
        return res;
    }
};
