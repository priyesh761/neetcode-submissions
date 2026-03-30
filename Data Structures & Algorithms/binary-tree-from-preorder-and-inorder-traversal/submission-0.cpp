/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
    TreeNode* build(vector<int>& pre, vector<int>& in, int l, int r, int& ind) {
        if(l>r || ind>=in.size()) return nullptr;
        if(l==r) return new TreeNode(pre[ind++]);

        int i=l;
        while(i<=r&& in[i]!=pre[ind]) i++;
        if(i>r) return nullptr;
        
        TreeNode* node = new TreeNode(pre[ind]);
        ind++;
        node->left = build(pre, in, l, i-1, ind);
        node->right = build(pre, in, i+1, r, ind);
        return node;
    }
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int ind=0;
        return build(preorder, inorder, 0, inorder.size(), ind);
    }
};
