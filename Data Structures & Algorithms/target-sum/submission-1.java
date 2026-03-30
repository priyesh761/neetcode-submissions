class Solution {
    private int findWay(int[] nums, int[][] dp, int ind, int target) {
        if(ind==nums.length) return target==0 ? 1: 0;
        int sum = (dp.length-1)/2;
        if(sum<target) return 0;
        System.out.println(""+dp.length+" "+sum+" "+target+" "+ind);
        if(dp[sum+target][ind]>=0) return dp[sum+target][ind];

        return dp[sum+target][ind] = findWay(nums, dp, ind+1, target-nums[ind])
            + findWay(nums, dp, ind+1, target+nums[ind]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int nm: nums) {
            sum += nm;
        }
        if(Math.abs(target)>sum) return 0;
        
        int[][] dp = new int[2*sum+1][nums.length];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return findWay(nums, dp, 0, target);
    }
}
