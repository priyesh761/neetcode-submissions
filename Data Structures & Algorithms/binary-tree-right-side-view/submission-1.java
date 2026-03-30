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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return List.of();
        Queue<TreeNode> qu = new ArrayDeque<>();
        Map<TreeNode, Integer> depth = new HashMap<>();
        qu.add(root);
        depth.put(root, 0);
        int lastDepth = -1;
        List<Integer> result = new ArrayList();
        while(!qu.isEmpty()) {
            TreeNode currentNode = qu.remove();
            int currentDepth = depth.get(currentNode);
            depth.remove(currentNode);
            if(currentDepth>lastDepth) {
                result.add(currentNode.val);
                lastDepth = currentDepth;
            }
            if(currentNode.right!=null) {
                qu.add(currentNode.right);
                depth.put(currentNode.right, currentDepth+1);
            }
            if(currentNode.left!=null) {
                qu.add(currentNode.left);
                depth.put(currentNode.left, currentDepth+1);
            }
        }
        return result;
    }
}
