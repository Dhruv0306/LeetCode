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

    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head, pre = null, curr = head;
        int ans = 0;
        //instead of going to mid and reversing second half
        //we simply can reverse first half till mid which reduce time
        while (fast != null) {
            fast = fast.next.next;
            curr = slow;
            slow = slow.next;
            curr.next = pre;
            pre = curr;
        }
        while (slow != null) {
            ans = Math.max(ans, pre.val + slow.val);
            slow = slow.next;
            pre = pre.next;
        }
        return ans;
    }

    // //if we reverse the second have the twins come in same order as we traverse from start in both parts
    // //so we can easily make sum
    // public int pairSum(ListNode head) {

    //     ListNode prev = null, end = head, mid = head, next = null, ptr=head;

    //     int maxSum = 0;
    //     while(end != null && end.next != null) {
    //         end = end.next.next;
    //         prev = mid;
    //         mid = mid.next; 
    //     }
    //     //reverse the second half
    //     while(mid != null) {
    //         next = mid.next;
    //         mid.next = prev;
    //         prev = mid;
    //         mid = next;
    //     }

    //     //prev is now starting point of reversed list
    //     while(true) {
    //         maxSum = Math.max(maxSum, prev.val + ptr.val);
    //         if(ptr.next == prev) break;
    //         ptr = ptr.next;
    //         prev = prev.next;
    //     }

    //    return maxSum; 

    // }
}