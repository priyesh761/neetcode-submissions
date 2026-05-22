class Solution {
    public int integerBreak(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        
        return calc(n, dp);
    }

    private int calc(int n, int[] dp) {
        if(n<2) return 1;
        if(dp[n]!=-1) return dp[n];

        for(int i=1;i<=n&&i<dp.length-1;i++) {
            dp[n] = Math.max(dp[n], i*calc(n-i, dp));
        }
        return dp[n];
    }
}