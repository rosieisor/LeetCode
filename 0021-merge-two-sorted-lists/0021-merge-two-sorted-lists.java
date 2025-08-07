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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode root = new ListNode();
        ListNode result = root;

        recursion(root, list1, list2);

        return result.next;
    }

    public void recursion(ListNode root, ListNode list1, ListNode list2) {
        if (list1 == null & list2 == null) {
            return;
        } else if (list1 == null) {
            root.next = list2;
            recursion(root.next, list1, list2.next);
        } else if (list2 == null) {
            root.next = list1;
            recursion(root.next, list1.next, list2);
        } else {
            ListNode node1 = new ListNode(list1.val);
            ListNode node2 = new ListNode(list2.val);

            if (list1.val == list2.val) {
                root.next = node1;
                root.next.next = node2;
                recursion(root.next.next, list1.next, list2.next);
            } else if (list1.val < list2.val) {
                root.next = node1;
                recursion(root.next, list1.next, list2);
            } else {
                root.next = node2;
                recursion(root.next, list1, list2.next);
            }
        }
    }
}