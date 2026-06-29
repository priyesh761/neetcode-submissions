class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            mp.compute(nums[i], (key,v) -> v==null?1:v+1);
            if(i>k) {
                mp.computeIfPresent(nums[i-k-1], (key, v) -> v-1);
            }
            if(mp.get(nums[i])>1) return true;
        }
        return false;
    }
}