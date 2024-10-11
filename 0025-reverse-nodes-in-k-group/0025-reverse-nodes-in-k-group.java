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

    public ListNode reverseKGroup(ListNode head, int k) {

        int size  = linkedListSize(head);

        ListNode[] ret = reverseList(head, k);
        ListNode result = ret[1];
        ListNode next = ret[2];
        ListNode last = ret[0];

        // System.out.println(ret[1].val + " -> " + ret[1].next.val + " -> " + ret[2].val);

        // System.out.println(size - (size % k));
        for (int i = k; i < (size - (size % k)); i+=k ) {
            
            ret = reverseList(next, k);

            // System.out.print(ret[1].val + " -> " + ret[1].next.val + " -> " + ret[2].val);
            last.next = ret[1];
            next = ret[2];
            last = ret[0];

        }

        last.next = next;

        // print(head);

        return result;
        
    }

    private void print(ListNode head){
        while(head.next != null){
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }

    private int linkedListSize(ListNode head){

        int size = 0;
        ListNode cur = head;
        while(cur != null){
            size++;
            cur = cur.next;
        }

        return size;
    }

    public ListNode[] reverseList(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        int index = 0;
        while (k != index) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
            index++;
        }
        return new ListNode[]{head,prev, curr};
    }
}