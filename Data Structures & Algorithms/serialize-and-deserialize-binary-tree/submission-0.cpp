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

class Codec {
    TreeNode* decode(string& data, int& ind) {
        if(ind>=data.size()) return nullptr;
        if(data[ind]=='#') {
            ind++;
            if(ind<data.size() && data[ind]==',') ind++;
            return nullptr;
        }

        string str;
        while(ind<data.length() && data[ind]>='0'&& data[ind<='9']) {
            str.push_back(data[ind]);
            ind++;
        }
        if(ind<data.length() && data[ind]==',') ind++;

        TreeNode* currNode = new TreeNode(stoi(str));
        currNode->left = decode(data, ind);
        currNode->right = decode(data, ind);
        return currNode;
    }
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* node) {
        if(node==nullptr) return "#";
        string left = serialize(node->left);
        string right = serialize(node->right);
        return to_string(node->val)+","+left+","+right;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        int ind=0;
        return decode(data, ind);
    }
};
