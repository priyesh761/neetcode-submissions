class Solution {
    public int splitArray(int[] nums, int k) {
        int sum=0, max=-1;
        for(int i: nums) {
            sum+=i;
            max = Math.max(max, i);
        }
        int l = max, r=sum, ans=-1;
        while(l<=r) {
            int m = l + (r-l)/2;
            int parts = calc(nums, m);
            if (parts<=k) {
                ans=m;
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return ans;
    }

    private int calc(int[] nums, int sum) {
        int parts=1, msum=0;
        for(int i: nums) {
            if(msum+i>sum) {
                msum = i;
                parts++;
            } else {
                msum += i;
            }
        }
        return parts;
    }
}