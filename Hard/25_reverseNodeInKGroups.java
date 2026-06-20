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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }

    public ListNode getKth(ListNode head, int k){
        ListNode temp = head;
        while(temp != null && k>1){
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currStart = head;
        ListNode prevLast = null;

        while(currStart != null){
            ListNode kthNode = getKth(currStart, k);

            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = currStart;
                    break;
                }
            }

            ListNode nextStart = kthNode.next;
            kthNode.next = null;

            if(currStart == head){
                head = reverse(currStart);
            }else{
                prevLast.next = reverse(currStart);
            }
            prevLast = currStart;
            currStart = nextStart;
            
        }

        return head;
    }
}
