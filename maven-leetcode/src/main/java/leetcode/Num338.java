package leetcode;

public class Num338 {
    class Solution {
        public int[] countBits(int num) {
            /**
             * 思路:动态规划，dp[i]表示i所拥有的1的个数
             * 对于当前值i，先将其减去小于等于它的最大2的次幂数c
             * dp[i] = dp[i-c]+1*/
            int [] dp = new int [num+1];
            int c = 1;
            if(num == 0){
                return dp;
            }
            dp[0] = 0;
            for(int i = 1; i < dp.length; i++){
                if(2*c <= i){
                    c *= 2;
                }
                dp[i] = dp[i - c] + 1;
            }
            return dp;
        }
    }
}
