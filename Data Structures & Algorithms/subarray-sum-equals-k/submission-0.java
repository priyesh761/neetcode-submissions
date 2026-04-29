class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int preSum=0, cnt=0;

        mp.put(0, 1);
        for(int i=0;i<nums.length;i++) {
            preSum += nums[i];
            cnt += mp.getOrDefault(preSum-k, 0);
            mp.compute(preSum, (key, val)-> val==null?1:val+1);
        }
        return cnt;
    }
}