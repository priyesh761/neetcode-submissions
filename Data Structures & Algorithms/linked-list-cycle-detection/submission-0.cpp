/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    bool hasCycle(ListNode* head) {
        ListNode* fast = head->next;
        while(head!=nullptr && fast!=nullptr) {
            head = head->next;
            fast = fast->next;
            if(fast) fast = fast->next;
            if(head == fast) return true;
        }
        return false;
    }
};
