class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
       int sum=0;
       for(int i: nums) {
            sum+=i;
       }
       if(sum%k!=0) return false;
        Boolean[] dp = IntStream.range(0, 1<<nums.length)
            .mapToObj(v -> (Boolean)null)
            .toArray(Boolean[]::new);                                                                                                                                                                                           
       return calc(nums, dp, 0, k, sum/k, 0, nums.length);
    }

    private boolean calc(int[] nums, Boolean[] dp, int mask, int k, int vl, int t, int sz) {
        if(sz==0) {
            return k==0;
        }
        if(dp[mask]!=null) return dp[mask];
        boolean res = false;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==-1) continue;
            if(t+nums[i]<=vl) {
                mask = mask | 1<<i;
                int temp = nums[i];
                nums[i] = -1;
                res = res || calc(nums
                    , dp
                    , mask
                    , t+temp==vl?k-1:k
                    , vl
                    , t+temp==vl?0:t+temp
                    , sz-1);
                nums[i] = temp;
                mask = mask ^ (1<<i);
            }
        }
        return dp[mask] = res;
    }
}