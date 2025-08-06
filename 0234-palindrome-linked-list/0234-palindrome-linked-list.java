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


import java.util.*;

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        List<Integer> valList = new ArrayList<>();

        while(true) {
            valList.add(head.val);
            
            if (head.next == null) {
                break;
            }
            
            head = head.next;
        }

        boolean flag = true;

        for(int i=0; i<valList.size(); i++) {
            if (valList.get(i) != valList.get(valList.size()-1-i)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}