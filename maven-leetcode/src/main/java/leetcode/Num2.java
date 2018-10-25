package leetcode;

public class Num2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 记录首节点
            ListNode res = new ListNode(-1);
            // 指向当前节点
            ListNode current = res;
            // 表示进位
            int c = 0;
            while (l1 != null || l2 != null) {
                int a = l1 == null ? 0 : l1.val;
                int b = l2 == null ? 0 : l2.val;
                int tmp = (a + b + c) % 10;
                c = (a + b + c) / 10;
                current.next = new ListNode(tmp);
                current = current.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            if (c == 1) {
                // 说明最高位进位
                current.next = new ListNode(1);
            }
            return res.next;
        }
    }
}
