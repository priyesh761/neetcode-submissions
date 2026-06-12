class Solution {
    public int calc(int[] nums, int ind, int curr) {
        if(ind==nums.length) return curr;
        int s1 = calc(nums, ind+1, curr^nums[ind]);
        int s2 = calc(nums, ind+1, curr);
        return s1+s2;
    }
    public int subsetXORSum(int[] nums) {
        return calc(nums, 0, 0);
    }
}