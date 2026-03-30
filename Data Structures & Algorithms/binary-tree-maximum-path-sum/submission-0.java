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
    public int computeMaxPath(TreeNode root, Map<TreeNode, Integer> maxSum) {
        if(root==null) return -10000000;
        int leftMax = computeMaxPath(root.left, maxSum);
        int rightMax = computeMaxPath(root.right, maxSum);

        maxSum.put(root, root.val + Collections.max(
            List.of(leftMax, rightMax, leftMax+rightMax, 0)));
        return root.val + Collections.max(
            List.of(leftMax, rightMax, 0));
    }

    public int getMax(TreeNode root, Map<TreeNode, Integer> maxSum) {
        if(root==null) return -10000000;
        int lMax = getMax(root.left, maxSum);
        int rMax = getMax(root.right, maxSum);

        return Collections.max(List.of(
            lMax,
            rMax,
            maxSum.get(root)));
    }

    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> maxSum = new HashMap();
        computeMaxPath(root, maxSum);
        return getMax(root, maxSum);
    }
}
