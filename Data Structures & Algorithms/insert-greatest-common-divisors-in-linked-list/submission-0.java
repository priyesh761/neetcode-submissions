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
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode prev, curr;
        curr = head;
        prev = null;

        while(curr!=null) {
            if(prev!=null) {
                prev.next = new ListNode(gcd(prev.val, curr.val), curr);
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}