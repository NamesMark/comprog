/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode tort = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tort = tort.next;
            hare = hare.next.next;
            if (tort == hare) {
                tort = head;
                while (tort != hare) {
                    tort = tort.next;
                    hare = hare.next;
                }
                return tort;
            }
        }

        return null;
    }
}