public class Num55 {
    class Solution {
        public boolean canJump(int[] nums) {
            /**
             * 思路：从前到后遍历数组，用max表示当前能达到的最远距离，遍历数组时
             * 元素下标不能超过max，在遍历过程中不断更新max，当max大于等于end时
             * 则能够到达end，否则不能。
             * 特殊情况是数组长度为1的情况，这时候一定能到达end，所以直接返回true
             */
            int max =nums[0];
            if (nums.length <= 1) {
                return true;
            }
            int i = 0;
            while(i < max){
                i++;
                if (max < i + nums[i]){
                    max = i + nums[i];
                }
                if (max >= nums.length - 1){
                    return true;
                }
            }
            return false;
        }
    }
}
