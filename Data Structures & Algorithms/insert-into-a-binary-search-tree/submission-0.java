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
    private TreeNode dfs(TreeNode root, int val, int l, int r) {
        if(root==null) {
            if(l<=val && val<=r) {
                return new TreeNode(val);
            } else return null;
        }

        root.left = dfs(root.left, val, l, root.val);
        root.right = dfs(root.right, val, root.val, r);
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) {
            return new TreeNode(val);
        }
        return dfs(root, val, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}