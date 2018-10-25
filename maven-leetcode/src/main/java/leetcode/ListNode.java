package leetcode;

import java.util.List;

/**
 * @author Fay
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    public static ListNode createByArray(int []nums){
        ListNode head = new ListNode(0);
        ListNode cur = head.next;
        for(int x : nums){
            cur = new ListNode(x);
            cur = cur.next;
        }
        return head.next;
    }

    @Override
    public boolean equals(Object n) {
        ListNode node;
        if(n instanceof ListNode){
            node = (ListNode)n;
        } else{
            return false;
        }
        if(node == this){return true;}
        ListNode cur1 = this;
        ListNode cur2 = node;
        while(cur1!=null && cur2!=null){
            if(cur1.val != cur2.val){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1 == null && cur2 == null;
    }
}
