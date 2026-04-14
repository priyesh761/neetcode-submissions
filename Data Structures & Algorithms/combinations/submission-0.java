class Solution {
    void fill(List<List<Integer>> res, Stack<Integer> list, int i, int n, int k) {
        if(list.size()==k) {
            res.add(new ArrayList(list));
            return;
        }
        while(i<=n) {
            list.push(i);
            fill(res, list, i+1, n, k);
            list.pop();
            i++;
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> list = new Stack<>();
        fill(res, list, 1, n, k);
        return res;
    }
}