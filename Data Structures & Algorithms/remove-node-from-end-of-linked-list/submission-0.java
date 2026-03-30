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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode currentNode = dummy, nthNode = dummy;
        int i=0;
        while(i<=n) {
            currentNode = currentNode.next;
            i++;
        }

        while(currentNode!=null) {
            currentNode = currentNode.next;
            nthNode = nthNode.next;
        }
        nthNode.next = nthNode.next.next;
        return dummy.next;
    }
}
