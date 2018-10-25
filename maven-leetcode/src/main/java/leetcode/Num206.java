package leetcode;

public class Num206 {
    class Solution {
        /**
         * 思路：迭代法。p0指向当前被处理节点的上一个节点
         * p1指向当前被处理的节点
         * p2指向当前被处理节点的下一个节点
         * 将p1指向p0,然后p0 = p1,p1 = p2,p2 = p2.next,直到p1为空，返回p0*/
        public ListNode reverseList(ListNode head) {
            if(head == null){return null;}
            ListNode p0 = null;
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
    }
}
