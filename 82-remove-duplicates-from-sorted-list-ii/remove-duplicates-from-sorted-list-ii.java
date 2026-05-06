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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(-1001, head);
        ListNode tempH = temp;
        while(tempH != null && tempH.next != null && tempH.next.next != null){
            if(tempH.next.val == tempH.next.next.val){
                ListNode temp2 = tempH.next.next;
                while(temp2 != null && temp2.val == tempH.next.val){
                    temp2 = temp2.next;
                }
                tempH.next = temp2;
            } else {
                tempH = tempH.next;
            }
        }
        return temp.next;
    }
}