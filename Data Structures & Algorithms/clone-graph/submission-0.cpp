/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
    Node* clone(Node* node, unordered_map<Node*, Node*>& mp) {
        if(node==nullptr) return node;
        if(mp.count(node)) return mp[node];
        Node* cloneNode = new Node(node->val);
        mp[node] = cloneNode;
        for(Node* ng: node->neighbors) {
            cloneNode->neighbors.push_back(clone(ng, mp));
        }
        return cloneNode;
    }
public:
    Node* cloneGraph(Node* node) {
        unordered_map<Node*, Node*> mp;
        return clone(node, mp);
    }
};
