class Solution {
    public int findMin(int[] nums) {
        int low=0, high=nums.length-1;

        while(low<=high) {
            int mid = low + (high-low)/2;

            if(nums[mid]>=nums[0]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return low == nums.length? nums[0]:nums[low];
    }
}
