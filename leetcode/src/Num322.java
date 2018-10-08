public class Num322 {
    class Solution {

        public int coinChange(int[] coins, int amount) {
            /**
             * 思想：同样是动态规划，dp[j]表示总额为j时的最小硬币数
             * 则 dp[j] = min(dp[j-val]+1,dp[j]) val为当前硬币的额度，要遍历所有硬币*/
            int MAX =  10000000;
            int []dp = new int[amount+1];
            dp[0] = 0;
            for(int j = 1; j <= amount; j++){
                dp[j] = MAX;
                for(int i = 0; i < coins.length; i++){
                    if(coins[i] <= j){
                        dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                    }
                }
            }
            if(dp[amount] == MAX){
                return -1;
            }
            return dp[amount];
        }
    }
}
