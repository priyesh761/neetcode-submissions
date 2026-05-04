class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = nums.length+1, s=0, sum=0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            while(s<=i&&sum>=target) {
                l = Math.min(l, i-s+1);
                sum -= nums[s];
                s++;
            }
        }
        return l==nums.length+1?0:l;
    }
}