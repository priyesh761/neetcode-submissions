class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r=nums.length-1, st=0;

        if(nums[l]>nums[r]) {
            while(l<=r) {
                int m = l + (r-l)/2;
                System.out.println(m);
                if(nums[m]<nums[0]) {
                    st=m;
                    r=m-1;
                } else {
                    l=m+1;
                }
            }
        }
        System.out.println(st);
        int n = nums.length;
        l = st;
        r = st+n-1;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(nums[m%n]==target) return m%n;
            else if(nums[m%n]<target) l=m+1;
            else r=m-1;
        }
        return -1;
    }
}
