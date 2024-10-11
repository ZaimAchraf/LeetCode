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

        ListNode result = null;
        int index = -1;
        ListNode tempmin = null, last = null;

        do {
            tempmin = null;
            index = -1;
            for (int i = 0; i < lists.length; i++) {

                if (lists[i] == null) continue;

                if (tempmin == null || lists[i].val < tempmin.val) {
                    tempmin = lists[i];
                    index = i;
                    continue;
                }
            }

            if (tempmin == null ) break;
            
            if (result == null) {
                result = tempmin;
            } else {
                last.next = tempmin;
            }
            
            last = tempmin;
            lists[index] = tempmin.next;

        } while (true);

        return result;
        
    }
}