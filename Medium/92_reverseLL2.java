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
        if(left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        
        for(int i = 1; i < left; i++) {
            start = start.next;
        }

        ListNode prev = null;
        ListNode curr = start.next;
        ListNode first = curr;
        // ListNode Next;
        for(int i=0; i<=right-left; i++){
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = Next;
        }

        start.next = prev;
        first.next = curr;

        return dummy.next;
    }
}
