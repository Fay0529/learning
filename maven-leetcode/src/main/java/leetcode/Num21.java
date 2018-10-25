package leetcode;

public class Num21 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    /**
     * 思路比较简单，类似归并排序的合并过程，只是用了链表*/
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            head 无用节点，为了方便后续操作并记录首节点
            ListNode head = new ListNode(-1);
//            p 指向当前的节点
            ListNode p = head;
            while(l1 != null && l2 != null){
                int a = l1.val;
                int b = l2.val;
                if(a < b) {
//                    如果 a < b，就将l1的节点接入p后面
                    p.next = l1;
                    p = p.next;
                    l1 = l1.next;
                } else {
//                    否则 将l2的节点接入后面，p指针后移
                    p.next = l2;
                    p = p.next;
                    l2 = l2.next;
                }
            }
//            最后有个不为空就直接将剩余的接到p后面即可
            if (l1 != null){
                p.next = l1;
            } else {
                p.next = l2;
            }
            return head.next;
        }
    }
}
