class Solution {
    private int lowerbound(int[] ar, int val) {
        int low = 0, high=ar.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(ar[mid]<val) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }
    public int lengthOfLIS(int[] nums) {
        int mx=1;
        int[] lis = new int[nums.length+1];
        Arrays.fill(lis, 1001);
        lis[0] = -1001;

        for(int i=0;i<nums.length; i++) {
            int index = lowerbound(lis, nums[i]);
            lis[index+1] = Math.min(lis[index+1], nums[i]);
            mx = Math.max(mx, index+1);
        }
        
        return mx;
    }
}
