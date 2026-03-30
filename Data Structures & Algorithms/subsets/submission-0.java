class Solution {
    private void genSubset(List<List<Integer>> list, Stack<Integer> st, int[] nums, int ind) {
        if(ind==nums.length) {
            list.add(new ArrayList(st));
            return;
        }

        genSubset(list, st, nums, ind+1);
        st.push(nums[ind]);
        genSubset(list, st, nums, ind+1);
        st.pop();
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        genSubset(list, new Stack(), nums, 0);
        return list;
    }
}
