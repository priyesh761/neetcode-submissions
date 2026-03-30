class Solution {
    public int coinChange(int[] coins, int[][] dp, int ind, int target) {
        if(ind==coins.length) return target==0? 1: 0;
        if(dp[ind][target]>=0) return dp[ind][target];

        dp[ind][target] = 0;
        for(int i=0;target>=coins[ind]*i;i++) {
            dp[ind][target] += coinChange(coins, dp, ind+1, target-coins[ind]*i);
        }
        return dp[ind][target];
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        dp[0][0] = 1;
        return coinChange(coins, dp, 0, amount);
    }
}
