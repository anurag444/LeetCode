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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //finding the middle 
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        
        
        //reverse the 2nd half
        ListNode curr = slow.next, prev = null;
        slow.next = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //now prev will have the reverse linked list head

        //merge two halves alternatively
        ListNode first = head;

        while(prev != null){
            ListNode temp1 = first.next;
            ListNode temp2 = prev.next;

            first.next = prev;
            prev.next = temp1;
            first = temp1;
            prev = temp2;
        }

    }
}