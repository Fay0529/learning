/**
 * @author Fay
 */
public class Num141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            /**
             * 思路：这是链表中的典型题目，判断一个链表有没有环路，可以用两个指针，一个指针一次跑两格，
             * 一个指针一次跑一格，如果相遇，则这个链表有环路，如果碰到null，则无环路*/
            ListNode fast = head;
            ListNode slow = head;
            while(fast != null && slow != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                } else { break;}
                if (fast == slow){
                    return true;
                }

            }
            return false;
        }
    }
}
