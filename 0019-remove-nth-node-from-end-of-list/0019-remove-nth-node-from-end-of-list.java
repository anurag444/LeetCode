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
        ListNode curr = head;

        int len = 0;

        while(curr != null){
            len++;
            curr = curr.next;
        }

        if(len == n) return head.next;

        len = len - n;

        curr = head;
        while(len > 1){
            curr = curr.next;
            len--;
        }

        

        curr.next = curr.next.next;


        return head;



    }
}