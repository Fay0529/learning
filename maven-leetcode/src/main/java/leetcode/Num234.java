package leetcode;

public class Num234 {
    class Solution {
        /**
         * 思路：首先找到链表的中点，可以用快慢指针的方式找到，然后将中点以后的链表反转
         * 再比较中点下一个点开始的链表与中点前的那个链表*/
        ListNode reverse(ListNode head){
            ListNode p0 = null;
            if(head== null){return null;}
            ListNode p1 = head;
            ListNode p2 = head.next;
            while(p1 != null){
                p1.next = p0;
                p0 = p1;
                p1 = p2;
                if(p2 != null){
                    p2 = p2.next;
                }
            }
            return p0;
        }
        public boolean isPalindrome(ListNode head) {
            if(head == null){return true;}
            ListNode fast = head;
            ListNode slow = head;
            while(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            fast = slow.next;
            fast = reverse(fast);
            while(fast != null){
                if(head.val != fast.val){
                    return false;
                }
                head = head.next;
                fast = fast.next;
            }
            return true;
        }
    }
}
