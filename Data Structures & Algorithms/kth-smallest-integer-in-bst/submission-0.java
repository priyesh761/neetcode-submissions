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
    private int count;
    private int ans=-1000;

    public int kthSmallest(TreeNode root, int k) {
        if(root==null || ans!=-1000) return ans;

        kthSmallest(root.left, k);
        count++;
        if(count==k){
            ans=root.val;
            return ans;
        }
        kthSmallest(root.right, k);
        return ans;
    }
}
