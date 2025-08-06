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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root;

        int num = 0;
        if (l1.val + l2.val >= 10) {
            num = 1;
            root = new ListNode(l1.val + l2.val - 10);
        } else {
            root = new ListNode(l1.val + l2.val);
        }

        l1 = l1.next;
        l2 = l2.next;

        ListNode result = root;
        ListNode node;

        while(true) {
            if (l1 == null && l2 == null) {
                if (num == 1) {
                    node = new ListNode(1);
                    root.next = node;
                }

                break;
            }

            int sum = 0;

            if (l1 == null) {
                sum = l2.val;
            } else if (l2 == null) {
                sum = l1.val;
            } else {
                sum = l1.val + l2.val;
            }

            if (num == 1) {
                if (sum + 1 >= 10) {
                    node = new ListNode(sum + 1 - 10);
                } else {
                    num = 0;
                    node = new ListNode(sum + 1);
                }
            } else {
                if (sum >= 10) {
                    num = 1;
                    node = new ListNode(sum - 10);
                } else {
                    node = new ListNode(sum);
                }
            }

            root.next = node;
            root = node;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }

        return result;
    }
}