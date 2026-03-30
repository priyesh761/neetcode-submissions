class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList();
        boolean[] mark = new boolean[nums.length];
        fill(nums, mark, curr, ans);
        return ans;
    }

    private void fill(int[] nums, boolean[] mark, List<Integer> curr, List<List<Integer>> ans) {
        if(nums.length==curr.size()) {
            List<Integer> cpy = new ArrayList<>(curr);
            ans.add(cpy);
        }
        for(int i=0;i<nums.length;i++) {
            if(mark[i]) continue;
            mark[i] = true;
            curr.add(nums[i]);
            fill(nums, mark, curr, ans);
            curr.removeLast();
            mark[i] = false;
        }
    }
}
