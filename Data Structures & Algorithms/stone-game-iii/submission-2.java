class Solution {

    private int[] calc(int[] stoneValue, int[][] dp, int ind) {
        if(ind>=stoneValue.length) return new int[]{0,0};
        if(dp[ind][0]!=Integer.MIN_VALUE) return dp[ind];
        if(ind==stoneValue.length-1) {
            dp[ind][0] = stoneValue[ind];
            dp[ind][1] = 0;
            return dp[ind];
        }

        int val = 0;
        for(int i=0;i<3&&ind+i<stoneValue.length;i++) {
            val+=stoneValue[ind+i];
            int[] v = calc(stoneValue, dp, ind+i+1);
            dp[ind][0] = Math.max(dp[ind][0], v[1]+val);
            dp[ind][1] = Math.min(dp[ind][1], v[0]);
        }
        return dp[ind];
    }
    public String stoneGameIII(int[] stoneValue) {
        int[][] dp = new int[stoneValue.length][2];
        for(int[] row: dp) {
            row[0]=Integer.MIN_VALUE;
            row[1]=Integer.MAX_VALUE;
        }
        int sum=0;
        for(int i: stoneValue) {
            sum+=i;
        }
        int[] v = calc(stoneValue, dp, 0);
        if(v[0]>sum-v[0]) {
            return "Alice";
        } else if(v[0]<sum-v[0]) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}