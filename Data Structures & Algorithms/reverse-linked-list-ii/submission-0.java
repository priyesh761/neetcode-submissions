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
        ListNode st = dummy, pre=null, post=null;
        for(int i=0;i<=right;i++) {
            if(i==left-1) pre = st;
            if(i==right) post = st;
            if(st!=null) st=st.next;
        }
        st = pre.next;
        pre.next = post;
        ListNode prev = post.next;
        for(int i=left;i<=right;i++) {
            ListNode next = st.next;
            st.next = prev;
            prev = st;
            st = next;
        }
        return dummy.next;
    }
}