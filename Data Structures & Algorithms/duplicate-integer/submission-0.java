class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int nm: nums) {
            if(st.contains(nm)) return true;
            st.add(nm);
        }
        return false;
    }
}