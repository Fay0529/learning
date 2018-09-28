/**
 * @author Fay
 */
public class Num142 {
    public class Solution {
        /**
         * 思路：判断是否有环同样可以用上题中的方法。如果有环，假设环开始的节点为A，环的大小为N
         * 如果快指针与慢指针相遇，快指针走的路程为慢的两倍，并且，快指针正好比慢指针快一圈
         * 慢指针走了A + B , 则快指针为2（A+B). ，且快指针比慢指针正好多走了一个环的长度，也就是N
         * 即 N = A + B；
         * 现在知道慢指针走到B节点时与快指针相遇，此时如果还有一个指针也开始从起点开始走，
         * 它走到A节点时，正好慢指针又回到了A节点，A节点就是我们要找的圈的起始节点
         * */
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow  = head;
            while(fast != null && slow != null){
                fast = fast.next;
                slow = slow.next;
                if(fast != null){fast = fast.next;}
                else { return null; }
                if(fast == slow){
                    ListNode tmp = head;
                    while(tmp != slow){
                        slow = slow.next;
                        tmp = tmp.next;
                    }
                    return tmp;
                }
            }
            return null;

        }
    }
}
