class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            while(nums[i]>0&&nums[i]<=nums.length&&i+1!=nums[i]) {
                if(nums[i]==nums[nums[i]-1]) break;
                int nxt = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = nxt;
            }
        }

        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
}