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
        head = new ListNode(-1,head);
        removeNth(head,n);
        return head.next;
    }

    public int removeNth(ListNode head, int n){
        if(head.next == null)return 0;
        int distance = removeNth(head.next, n);
        if(distance == n-1){
            head.next = head.next.next;
        }
        return distance +1;
    }
}