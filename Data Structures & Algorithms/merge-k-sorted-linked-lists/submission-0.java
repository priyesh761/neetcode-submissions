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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((x, y) -> x.val - y.val);
        for(ListNode node: lists) {
            pq.add(node);
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            ListNode top = pq.poll();
            if(top.next!=null) {
                pq.add(top.next);
            }
            curr.next = top;
            curr = curr.next;
        }
        return dummy.next;
    }
}
