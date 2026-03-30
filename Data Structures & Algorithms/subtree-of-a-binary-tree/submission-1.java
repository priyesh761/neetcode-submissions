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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) {
            return root==subRoot;
        }
        if(subRoot==null) return false;

        boolean isSub=match(root, subRoot);
        return isSub
        || isSubtree(root.left, subRoot)
        || isSubtree(root.right, subRoot);
    }

    public boolean match(TreeNode root, TreeNode sub) {
        if(root==null) return root==sub;
        if(sub==null) return false;

        if(root.val!=sub.val) return false;
        return match(root.left, sub.left)
            && match(root.right, sub.right);
    }
}
