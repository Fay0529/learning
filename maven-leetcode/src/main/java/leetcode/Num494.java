package leetcode;

public class Num494 {
    class Solution {
        /**
         * 思路：可利用递归进行枚举，但是这样做提交发现效率并不高
         * 所以因为这题只要求出所有可能的数量，不需要列举出来，所以可采用更高效的算法
         * 参考discuss中的做法，nums数组会被分为positive组合negative组
         * sum(p)-sum(n) = target
         * sum(p) + sum(n) + sum(p) - sum(n) = target + sum(p) + sum(n)
         * 2sum(p) = target + sum(nums)
         * sum(p) = (target + sum(nums))/2
         * 因此问题化解为从nums中找到和为(target + sum(nums))/2的所有子集的个数
         * 这就要求target+sum(nums)必须为偶数，否则无解
         * 这就变成了类似01背包问题的dp问题，令dp[i]表示和为i的所有子集个数，则
         * dp[i] = sum(dp[i-nums[j]])*/
        public int findTargetSumWays(int[] nums, int S) {
            int sum = S;
            for(int i =0; i < nums.length; i++){
                sum += nums[i];
            }
            if(sum % 2 != 0 || S*2 > sum){
                return 0;
            }
            return dpSolution(nums,sum >> 1);
        }
        public int dpSolution(int [] nums,int sum){
            // 数组默认值为0，所以不进行初始化
            int [] dp = new int [sum + 1];
            dp[0] = 1;
            for(int i = 0; i < nums.length; i++){
                for(int j = sum; j >= nums[i]; j--){
                    dp[j] += dp[j - nums[i]];
                }
            }
            return dp[sum];

        }

    }
}
