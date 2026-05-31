class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0, r = nums.length-1, ans=-1;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(nums[m]>=target) {
                ans = m;
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return ans==-1?nums.length:ans;
    }
}