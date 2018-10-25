package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Num2Test {
    @Test
    public void test(){
        Num2 num2 = new Num2();
        Num2.Solution s = num2.new Solution();
        int [] nums1 = {2,4,3};
        int [] nums2 = {5,6,4};
        int [] nums3 = {7,0,8};
        ListNode l1 = ListNode.createByArray(nums1);
        ListNode l2 = ListNode.createByArray(nums2);
        ListNode expect = ListNode.createByArray(nums3);
        ListNode res = s.addTwoNumbers(l1,l2);
        assertEquals(expect,res);
    }
}
