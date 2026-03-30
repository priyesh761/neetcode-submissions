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
    int countGoodNodes(TreeNode* root, int maxVal) {
        if(root==nullptr) return 0;

        return (root->val>=maxVal ? 1:0)
            + countGoodNodes(root->left, max(root->val, maxVal))
            + countGoodNodes(root->right, max(root->val, maxVal));
    }
public:
    int goodNodes(TreeNode* root) {
        return countGoodNodes(root, INT_MIN);
    }
};
