class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
       int sum=0;
       for(int i: nums) {
            sum+=i;
       }
       if(sum%k!=0) return false;

       return calc(nums, k, sum/k, 0, nums.length);
    }

    private boolean calc(int[] nums, int k, int vl, int t, int sz) {
        if(sz==0) {
            return k==0;
        }
        boolean res = false;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==-1) continue;
            if(t+nums[i]<=vl) {
                int temp = nums[i];
                nums[i] = -1;
                res = res || calc(nums
                    , t+temp==vl?k-1:k
                    , vl
                    , t+temp==vl?0:t+temp
                    , sz-1);
                nums[i] = temp;
            }
        }
        return res;
    }
}