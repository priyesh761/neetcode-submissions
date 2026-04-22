class Solution {
    private void fill(int[] nums, ArrayDeque<Integer> curr, List<List<Integer>> res) {
        if(curr.size()==nums.length) {
            res.add(new ArrayList(curr));
            return;
        }
        int i=0;
        while(i<nums.length) {
            if(nums[i]==-100||(i>0&&nums[i]==nums[i-1])) {
                i++;
                continue;
            }
            curr.addLast(nums[i]);
            nums[i]=-100;
            fill(nums, curr, res);
            nums[i] = curr.removeLast();
            i++;
        }
        return;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ArrayDeque<Integer> curr = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        fill(nums, curr, res);
        return res;
    }
}