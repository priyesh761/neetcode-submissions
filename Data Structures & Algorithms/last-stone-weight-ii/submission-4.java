class Solution {
    int calc(int[] stones, int[][] dp, int p1, int p2, int ind) {
        if(ind==stones.length) return Math.abs(p1-p2);
        if(dp[ind][p1]!=-1) return dp[ind][p1];

        return dp[ind][p1] = Math.min(
            calc(stones, dp, p1+stones[ind], p2, ind+1),
            calc(stones, dp, p1, p2+stones[ind], ind+1));
    }
    public int lastStoneWeightII(int[] stones) {
        int[][] dp = new int[stones.length][100000];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return calc(stones, dp, 0, 0, 0);
    }
}