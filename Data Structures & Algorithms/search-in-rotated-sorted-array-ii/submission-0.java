class Solution {
    private boolean bsd(int[] nums, int l, int r, int target) {
      if(l==r) return target==nums[l];
      int m = l + (r-l)/2;
      boolean ans = false;
      if(nums[l]<=nums[m]) {
        ans = ans || bs(nums, l, m, target);
      } else {
        ans = ans || bsd(nums, l, m, target);
      }
      if(nums[m+1]<=nums[r]) {
        ans = ans || bs(nums, m+1, r, target);
      } else {
        ans = ans || bsd(nums, m+1, r, target);
      }
      return ans;
    }

    private boolean bs(int[] nums, int l, int r, int target) {
      if(l==r) return target==nums[l];
      while(l<=r) {
        int m = l + (r-l)/2;
        if(nums[m]<target) {
          l=m+1;
        } else if(nums[m]>target) {
          r=m-1;
        } else {
          return true;
        }
      }
      return false;
    }
    public boolean search(int[] nums, int target) {
      int l=0, r=nums.length-1, ans=-1;
      return bsd(nums, l, r, target);
    }
}