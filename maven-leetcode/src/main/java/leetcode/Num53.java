package leetcode;

public class Num53 {
    class Solution {
        /**
         * 这题是最大子序列和的问题
         * 采用动态规划算法，令dp[i]表示以i结尾的最大子序列和
         * 则dp[i + 1] = max{dp[i] + nums[i],nums[i]} */
        public int maxSubArray(int[] nums) {
            int [] dp = new int[nums.length];
            int max = nums[0];
            dp[0] = nums[0];
            for (int i = 1; i < dp.length; i++){
                if(dp[i-1] > 0) {
                    dp[i] = dp[i - 1] + nums[i];
                } else {
                    dp[i] = nums[i];
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;
        }
    }
}
