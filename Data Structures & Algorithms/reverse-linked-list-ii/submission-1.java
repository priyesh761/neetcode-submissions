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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode st = dummy, pre=null, first = null, post=null;
        for(int i=0;i<=right;i++) {
            ListNode next = st.next;
            if(i==left-1) {
                first = st;
            } else if(i>left && i<=right) {
                if(i==right) {
                    first.next.next = next;
                    first.next = st;
                }
                st.next = pre;
            }
            pre=st;
            st = next;
        }
        return dummy.next;
    }
}