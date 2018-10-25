package leetcode;

public class Num136 {
    class Solution {
        public int singleNumber(int[] nums) {
            /**
             * 思路：可采用异或的思想，出现过两次的数经过异或后就变成零了，最后留下来的是出现一次的数*/
            int res = nums[0];
            for(int i = 1; i < nums.length; i++){
                res ^= nums[i];
            }
            return res;
        }
    }
}
