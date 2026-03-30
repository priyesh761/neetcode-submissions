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
    bool validate(TreeNode* root, int lft=INT_MIN, int rgt=INT_MAX) {
        if(root==nullptr)  return true;
        if(root->val<=lft || root->val>=rgt) return false;

        return validate(root->left, lft, root->val) &&
            validate(root->right, root->val, rgt);
    }
public:
    bool isValidBST(TreeNode* root) {
        return validate(root);
    }
};
