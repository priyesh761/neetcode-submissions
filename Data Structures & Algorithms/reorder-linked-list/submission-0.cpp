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
    ListNode* reorder(ListNode* curr, ListNode* head) {
        if(curr==nullptr) {
            return head;
        }
        ListNode* pre = reorder(curr->next, head);
        if(pre==nullptr) return nullptr;
        if(pre==curr) return pre->next = nullptr;

        // if(next->next==curr || next==curr) return nullptr;
        ListNode* tmp = pre->next;
        pre->next = curr;
        curr->next = (curr==tmp)? nullptr : tmp;
        return curr->next;
    }
public:
    void reorderList(ListNode* head) {
        reorder(head, head);
    }
};
