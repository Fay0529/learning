public class Num198 {
    class Solution {
        public int rob(int[] nums) {
            /**
             * 思路，采用动态规划的算法，假设偷的用户数两至少有四个（小于等于三个可以直接求出来）
             * dp[i] 表示一定偷用户i的情况下，最多能偷多少钱
             * 那么dp[i] = max(nums[i]+dp[i-2],nums[i]+dp[i-3]);
             * 因为用户i被偷，用户i-1一定不能偷，所以dp[i]与dp[i-1]没有关系，而用户i-2和用户i-3这两个必须偷一个才能达到最优解*/
            if(nums.length == 0){return 0;}
            if(nums.length == 1){return nums[0];}
            int [] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            dp[1] = nums[1];
            if(max < dp[1]){max = dp[1];}
            if(nums.length == 2){return max;}
            dp[2] = nums[0]+nums[2];
            if(max < dp[2]){max = dp[2];}
            if(nums.length == 3){return max;}
            for(int i = 3; i < nums.length; i++){
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-3]+nums[i]);
                if(max < dp[i]){
                    max = dp[i];
                }
            }
            return max;
        }
    }
}
