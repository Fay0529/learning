package leetcode;

public class Num287 {
    class Solution {
        /**如果不使用O(1)的空间复杂度，这题用hash就可以
         * 当前的解法是，将每个元素的值当做下一个要访问元素的下标
         * 这是因为n+1个元素中有1~n n个数，最大n也正好为数组下标界限，
         * 这样遍历可以无限遍历下去过程类似链表的访问
         * 通过画图可以知道，会因为重复的元素而形成圈，并且圈的起点就是重复元素
         * 因此目标就是找到圈的起点*/
        public int findDuplicate(int[] nums) {
            int fast = nums[0];
            int slow = nums[0];
            // 首先找到fast和slow相遇的点
            do{
                fast = nums[nums[fast]];
                slow = nums[slow];
            }while(fast != slow);
            // 然后让一个指针从头开始与slow同时往下走，它们相遇的点就是圈的起始位置
            fast = nums[0];
            while(fast != slow){
                fast = nums[fast];
                slow = nums[slow];
            }
            return fast;
        }
    }
}
