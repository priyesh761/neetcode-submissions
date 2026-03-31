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
class Pair<K, V> {
    public K first;
    public V second;

    Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return List.of();
        Queue<Pair<TreeNode, Integer>> qu = new ArrayDeque<>();
        qu.add(new Pair(root, 0));
        List<List<Integer>> list = new ArrayList<>();
        while(!qu.isEmpty()) {
            Pair<TreeNode, Integer> currNode = qu.remove();
            TreeNode node = currNode.first;
            int lev = currNode.second;
            if(list.size()<lev+1) {
                list.add(new ArrayList());
            }
            list.get(lev).add(node.val);
            if(node.left!=null) qu.add(new Pair<TreeNode, Integer>(node.left, lev+1));
            if(node.right!=null) qu.add(new Pair<TreeNode, Integer>(node.right, lev+1));
        }
        return list;
    }
}
