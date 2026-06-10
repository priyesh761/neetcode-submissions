class Solution {
    private void calc(int[][][] dp, int[] piles, int ind, int m) {
        if(ind==piles.length) return;
        if(dp[ind][m][0]!=-1) return;
        dp[ind][m][0] = 0;
        dp[ind][m][1] = Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<2*m&& ind+i<piles.length;i++) {
            sum+=piles[ind+i];
            int nm = Math.max(i+1, m);
            int nind = ind+i+1;
            calc(dp, piles, ind+i+1, nm);
            dp[ind][m][0] = Math.max(dp[ind][m][0], (nind==piles.length?0:dp[nind][nm][1]) + sum); 
            dp[ind][m][1] = Math.min(dp[ind][m][1], nind==piles.length?0:dp[nind][nm][0]);
        }
        return;
    }
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[piles.length][2*piles.length][2];
        for(int[][] r1: dp) {
            for(int[] r2: r1) {
                Arrays.fill(r2, -1);
            }
        }
        calc(dp, piles, 0, 1);
        return dp[0][1][0];
    }
}