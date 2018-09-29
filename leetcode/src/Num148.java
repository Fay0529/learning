public class Num148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            /**思想，这题要求O(nlogn)并且常数空间复杂度，那么可以想到的是快速排序和归并排序
             * 归并排序稳定在O(nlogn)所以首选归并排序
             * 归并排序在本题中的思路，要将链表不断的切分成两半，需要找到中间节点，这里可以用快慢指针的方法去找
             * 找到中间节点后将链表切分成两个链表，分而治之*/
            if(head == null || head.next == null){return head;}
            ListNode slow = head;
            ListNode fast = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode mid = slow;
            slow = slow.next;
            mid.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(slow);
            ListNode p = mergeList(left,right);
            return p;

        }
        public ListNode mergeList(ListNode list1,ListNode list2){
            if(list1 == null){return list2;}
            if(list2 == null){return list1;}
            // 增加一个空节点作为结果的首节点
            ListNode head = new ListNode(-1);
            ListNode p = head;
            while(list1 != null && list2 != null){
                if(list1.val < list2.val){
                    p.next = list1;
                    list1 = list1.next;
                } else {
                    p.next = list2;
                    list2 = list2.next;
                }
                p = p.next;
            }
            if(list1 != null){
                p.next = list1;
            } else{
                p.next = list2;
            }
            return head.next;
        }
    }
}
