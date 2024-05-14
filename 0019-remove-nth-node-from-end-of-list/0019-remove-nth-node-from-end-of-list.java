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
        ListNode temp = head;
        
        int size = 1;
        
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        
        ListNode node = head;
        
        size = size - n - 1;
        
        if(size == -1) return head.next;
        
        while(size > 0){
            head = head.next;
            size--;
        }
        
        head.next = head.next.next;
        
        return node;
        
    }
}