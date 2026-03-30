/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reverse(ListNode curr, ListNode pre, int k) {
        if(k==0||curr==null) { return; }

        reverse(curr.next, curr, k-1);
        curr.next=pre;
        return;
    }

    public ListNode getKthNode(ListNode curr, int k) {
        if(k==1 || curr==null) return curr;
        return getKthNode(curr.next, k-1); 
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = head, prev = dummy;
        while(curr!=null) {
            ListNode rFirst = getKthNode(curr, k);
            if(rFirst==null) break;
            ListNode next = rFirst.next;
            reverse(curr, prev, k);
            curr.next = next;
            prev.next = rFirst;
            prev = curr;
            curr = next;
        }
        return dummy.next;
    }
}
