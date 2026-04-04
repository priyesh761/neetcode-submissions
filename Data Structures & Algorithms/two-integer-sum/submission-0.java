class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(mp.containsKey(target-nums[i])) {
                return new int[] { mp.get(target-nums[i]), i};
            }
            final int v = i;
            mp.computeIfAbsent(nums[i], k->v);
        }
        return new int[]{};
    }
}
