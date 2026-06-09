/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Map.Entry<TreeNode, Boolean>, Integer> mp;
    private int max(TreeNode root, boolean robbed) {
        if(root==null) return 0;
        Map.Entry<TreeNode, Boolean> key = Map.entry(root, robbed);
        if(mp.containsKey(key)) return mp.get(key);
        if(robbed) {
            int val = max(root.left, false) + max(root.right, false);
            mp.put(key, val);
            return val;
        }
        int p1  = root.val + max(root.left, true) + max(root.right, true);
        int p2 = max(root.left, false) + max(root.right, false);
        int val = Math.max(p1, p2);
        mp.put(key, val);
        return val;
    }
    public int rob(TreeNode root) {
        mp= new HashMap<>();
        return max(root, false);
    }
}