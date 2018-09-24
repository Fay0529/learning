public class Num19 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    /**
     * 思路：简单的链表删除，题目说能不能遍历一遍解决问题，我看了答案没有遍历一遍的
     * 有的用两个指针，一个指针先走n步，然后两个指针一起走，其实这样也是遍历了两边，同样是两个循环
     * 时间效率上与我先遍历一遍得到长度，然后再从前到后遍历一样*/
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int len = 0;
            ListNode p = head;
            while(p != null) {
                p = p.next;
                len++;
            }
            if (len  == n) {
                return head.next;
            }
            int cnt = 1 ;
            p = head;
            while(cnt < len - n) {
                cnt ++;
                p = p.next;
            }
            p.next = p.next.next;
            return head;
        }
    }
}
