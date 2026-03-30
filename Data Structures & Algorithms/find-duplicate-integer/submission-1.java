class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            while(nums[i]!=i+1) {
                if(nums[nums[i]-1]==nums[i]) return nums[i];
                int temp = nums[i];
                int ind = nums[i]-1;
                nums[i] = nums[ind];
                nums[ind] = temp;
            }
        }
        return -1;
    }
}
