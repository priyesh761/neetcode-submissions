class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        for(int i: nums) {
            sum+=i;
        }
        int[] num2 = IntStream.range(0, 2*nums.length-1)
            .map(i -> nums[i%nums.length])
            .toArray();
        int mx=nums[0], mn=nums[0], curr=nums[0], curr2=nums[0];
        for(int i=1;i<nums.length;i++) {
            curr = Math.max(nums[i], curr+nums[i]);
            curr2 = Math.min(nums[i], curr2+nums[i]);
            mx = Math.max(curr, mx);
            mn = Math.min(mn, curr2);
        }
        System.out.println(""+mx+" "+sum+" "+mn);
        return Math.max(mx, sum!=mn?sum-mn:mx);
    }
}