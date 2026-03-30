/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        Node* head2 = new Node(-1);
        Node* head1 = head, *prev=head2;
        unordered_map<Node*, Node*> mp;
        while(head1!=nullptr) {
            Node* newNode = new Node(head1->val);
            prev->next = newNode;
            mp[head1] = newNode;
            prev = newNode;
            head1 = head1->next;
        }
        for(auto i: mp) {
            if(i.first->random!=nullptr)
                i.second->random = mp[i.first->random];
        }
        return head2->next;
    }
};
