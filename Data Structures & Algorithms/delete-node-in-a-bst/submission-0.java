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
    public TreeNode deleteNode(TreeNode root, int key) {
        List<Integer> tree = new ArrayList<>();
        getListFromTree(root, tree);
        tree.remove(Integer.valueOf(key));
        System.out.println(tree);
        return buildTreeFromList(tree, 0, tree.size());
    }

    private void getListFromTree(TreeNode root, List<Integer> list) {
        if(root==null) return;
        getListFromTree(root.left, list);
        list.add(root.val);
        getListFromTree(root.right, list);
    }

    private TreeNode buildTreeFromList(List<Integer> tree, int start, int end) {
        if(start>=end) return null;
        if(start==end-1) return new TreeNode(tree.get(start)); 
        int mid = start + (end-start)/2;
        TreeNode curr = new TreeNode(tree.get(mid));
        curr.left = buildTreeFromList(tree, start, mid);
        curr.right = buildTreeFromList(tree, mid+1, end);
        return curr;
    }
}