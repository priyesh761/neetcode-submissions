class Solution {
    public void dfs(int[] nums,
        List<List<Integer>> res,
        List<Integer> sub,
        int ind) {
            if(ind==nums.length) {
                res.add(new ArrayList(sub));
                return;
            }
                
            sub.add(nums[ind]);
            dfs(nums, res, sub, ind+1);
            sub.removeLast();
            int j=ind;
            while(ind<nums.length && nums[ind]==nums[j]) ind++;
            dfs(nums, res, sub, ind);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, res, subset, 0);
        return res;
    }
}
