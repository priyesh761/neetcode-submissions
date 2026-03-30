class Solution {
    public int computeMax(
        int[] nums,
        int[][] dp,
        int l,
        int r) {
        if(dp[l][r]!=-1) return dp[l][r];
        if(r<l+2) return dp[l][r] = 0;
        
        int mx = -1;
        for(int i=l+1; i<r; i++) {
            int mul = nums[i]*nums[l]*nums[r];
            mx = Math.max(mx,
                mul
                + computeMax(nums, dp, l, i)
                + computeMax(nums, dp, i, r)
            );
        }
        return dp[l][r] = mx;
    }
    public int maxCoins(int[] nums) {
        int[] updatedNum = new int[nums.length+2];
        for(int i=0;i<nums.length;i++){
            updatedNum[i+1] = nums[i];
        }
        updatedNum[0] = 1;
        updatedNum[updatedNum.length-1]=1;
        int[][] dp = new int[updatedNum.length][updatedNum.length];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        };

        return computeMax(updatedNum, dp, 0, updatedNum.length-1);
    }
}
