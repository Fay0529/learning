package leetcode;

public class Num160 {
    /**思路：可先分别统计两个链表长度，然后再让长的链表指针先走几步，再两个同时走，第一次相遇的位置即为交叉的位置
     * 否则不交叉*/
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null){return null;}
            int aLen = 0;
            int bLen = 0;
            ListNode aPoint = headA;
            ListNode bPoint = headB;
            while(aPoint != null){
                aLen++;
                aPoint = aPoint.next;
            }
            while(bPoint != null){
                bLen++;
                bPoint = bPoint.next;
            }
            if(aLen < bLen){
                for(int i = 0; i < bLen - aLen; i++){
                    headB = headB.next;
                }
            } else if(aLen > bLen){
                for(int i = 0; i < aLen - bLen; i++){
                    headA = headA.next;
                }
            }
            while(headA != null && headB != null){
                if(headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;

        }
    }
}
