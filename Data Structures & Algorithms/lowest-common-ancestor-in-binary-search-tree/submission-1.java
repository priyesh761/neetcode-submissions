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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if ((left!=null && right!=null && left.val==p.val && right.val==q.val)
            || (left!=null && right!=null && left.val==q.val && right.val==p.val)
            || (left!=null && root.val==p.val && left.val==q.val)
            || (left!=null && root.val==q.val && left.val==p.val)
            || (right!=null && root.val==p.val && right.val==q.val)
            || (right!=null && root.val==q.val && right.val==p.val)) { return root; }

        if (left!=null && (left.val==p.val || left.val==q.val)) { return left; }
        if (right!=null && (right.val==p.val || right.val==q.val)) { return right; }
        if (root.val==p.val || root.val==q.val) return root;
        if(left!=null) return left;
        if(right!=null) return right;

        return null;
    }
}
