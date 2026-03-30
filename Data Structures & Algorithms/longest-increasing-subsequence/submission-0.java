class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        int mx=1;
        for(int i=0;i<nums.length;i++) {
            dp[i+1] = 1;
            for(int j=0; j<i; j++) {
                if(nums[j]<nums[i]) {
                    dp[i+1] = Math.max(dp[j+1]+1, dp[i+1]);
                    mx = Math.max(mx, dp[i+1]);
                }
            }
        }
        return mx;
    }
}
