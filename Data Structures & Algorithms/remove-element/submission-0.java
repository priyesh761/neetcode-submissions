class Solution {
    public int removeElement(int[] nums, int val) {
        int l=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=val) {
                int temp = nums[i];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
            }
        }
        return l;
    }
}