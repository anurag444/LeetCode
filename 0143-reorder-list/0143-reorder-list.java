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
        int len = 1;

        ListNode temp = head;

        while(temp.next != null){
            temp = temp.next;
            len++;
        }

        
        if(len % 2 != 0) len++;
        len /= 2;
        ListNode mid = head;

        //go to the mid element
        while(len != 1){
            len--;
            mid = mid.next;
        }


        ListNode prev = null;
        ListNode temp1;
        

        while(mid != null){
            temp1 = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp1;
        }

        mid = prev;

        ListNode res = head;
        ListNode new1;
        ListNode new2;

        while(mid != null && res != null){
            new1 = res.next;
            res.next = mid;
            new2 = mid.next;
            mid.next = new1;
            mid = new2;
            res = new1;
        }

    }
}