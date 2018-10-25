package leetcode;

public class Num416 {
    /**
     * 思路：首先求出所有数的和 sum,如果为奇数直接返回false，如果为偶数，取sum的一半作为背包容量进行01背包问题求解
     * 令dp[j] 为恰好装满容量为j的背包的最大元素个数
     * dp[j] = max(dp[j],dp[j-nums[i]]+1)*/
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum+=nums[i];
            }
            if(sum % 2 != 0){return false;}
            sum >>= 1;
            int [] dp = new int[sum+1];
            dp[0] = 0;
            for(int i = 1; i < dp.length; i++){
                dp[i] = Integer.MIN_VALUE;
            }
            for(int i = 0; i < nums.length; i++){
                for(int j = sum; j >= nums[i]; j--){
                    dp[j] = Math.max(dp[j],dp[j-nums[i]]+1);
                }
            }
            if(dp[sum] < 0){
                return false;
            }
            return true;
        }
    }
}
