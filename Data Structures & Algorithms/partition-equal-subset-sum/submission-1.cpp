class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum=0;
        for(auto i: nums) {
            sum+=i;
        }
        if(sum%2==1) return false;
        vector<bool> dp(sum/2+1);
        dp[0] = true;
        for(auto j: nums) {
            for(int i=sum/2;i>0;i--) {
                if(i-j>=0 && dp[i-j]==true) {
                    dp[i] = true;
                }
            }
        }
        return dp[sum/2];
    }
};
