/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        Node next;

        // creating a copy of each node and adding it to the right of the node
        while(current != null){
            next = current.next;
            Node copy = new Node(current.val);
            current.next = copy;
            copy.next = next;
            current = next;
        }

        current = head;

        //assigning the random pointer for the copies
        while(current != null){
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        //restore the original list and extract the copied list

        current = head;
        Node dummy = new Node(0);
        Node copy, tail = dummy;

        while(current != null){
            next = current.next.next;

            copy = current.next;
            tail.next = copy;
            tail = copy;

            current.next = next;
            current = next;
        }

        return dummy.next;
    }
}