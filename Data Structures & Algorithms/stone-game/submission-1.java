class Solution {
    private int calc(int[] piles, int[][] dp, int l, int r) {
        if(l>r) return 0;
        if(l==r) return dp[l][r] = piles[l];
        if(dp[l][r]!=-1) return dp[l][r];

        int c1 = piles[l] + Math.max(
            calc(piles, dp, l+1, r-1),
            calc(piles, dp, l+2, r));
        int c2 = piles[r] + Math.max(
            calc(piles, dp, l, r-2),
            calc(piles, dp, l+1, r-1));
        return dp[l][r] = Math.max(c1, c2);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int total = 0;
        for(int i: piles) {
            total += i;
        }
        int mx = calc(piles, dp, 0, n-1);

        return total-mx<mx;
    }
}