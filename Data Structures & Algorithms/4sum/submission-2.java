class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        Map<Long, List<List<Integer>>> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            for(int k=0;k<i-1;k++) {
                int v1 = nums[k];
                int v2 = nums[i-1];
                mp.compute((long)nums[i-1]+nums[k], (ke,v)->{
                    List<List<Integer>> pair = v;
                    if(v==null) {
                        pair = new ArrayList<>();
                    }
                    pair.add(List.of(v1, v2));
                    return pair;
                });
            }
            for(int j=i+1;j<nums.length;j++) {
                long req = (long)target-nums[i]-nums[j];
                if(mp.containsKey(req)) {
                    for(List<Integer> pair: mp.get(req)) {
                        res.add(List.of(pair.get(0), pair.get(1), nums[i], nums[j]));
                    }
                }
            }
        }
        return res.stream().toList();
    }
}