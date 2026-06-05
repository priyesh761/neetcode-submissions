class Solution {
    public int numSquares(int n) {
        int[] dp = IntStream.range(0,n+1)
            .map(i->-1)
            .toArray();
        dp[0]=0;
        dp[1]=1;
        return numSquares(n, dp);
    }
    public int numSquares(int n, int[] dp) {
        if(dp[n]!=-1) return dp[n];

        int mn = n, x=1;
        for(int i=1;i*i<=n;i++) {
            x=i;
        }
        while(x>0) {
            mn = Math.min(1+numSquares(n-x*x, dp), mn);
            x--;
        }
        return dp[n]=mn;
    }
}