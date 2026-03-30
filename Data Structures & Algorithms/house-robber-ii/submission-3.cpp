class Solution {
    int calc(vector<int>& nums) {
        int size = nums.size();
        if(size==1) return nums[0];

        vector<int> dp(size+1);
        dp[1] = nums[0];
        dp[2] = nums[1];
        for(int i=2;i<size;i++){
            dp[i+1] = max(dp[i-1], dp[i-2]) + nums[i];
        }

        return *max_element(dp.begin(), dp.end());
    }
public:
    int rob(vector<int>& nums) {
        int size = nums.size();
        if(size==1) return nums[0];
        vector<int> st1(nums.begin(), nums.begin()+nums.size()-1);
        vector<int> st2(nums.begin()+1, nums.end());
        return max(calc(st1), calc(st2));
    }
};
