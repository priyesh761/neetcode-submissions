class Solution {
    public void sortColors(int[] nums) {
        int l=-1, r=nums.length;

        int i=0;
        while(i<r) {
            if(l<i&&nums[i]==0) {
                l++;
                nums[i] = nums[l];
                nums[l] = 0;
            }
            if(r>i&&nums[i]==2) {
                r--;
                nums[i] = nums[r];
                nums[r] = 2;
            }
            if(nums[i]==1||l>=i) i++;
        }
        return;
    }
}