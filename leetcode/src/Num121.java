public class Num121 {
    class Solution {
    /**
     * 思路：这题可以用动态规划去解决问题
     * 令dp[i] 表示第i天售出时的最大收益，那么dp[i] = max(dp[i-1] + price[i] - price[-1],price[i] - price[-1])
     * 其中dp[0] = 0*/
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length < 2){return 0;}
        int [] dp = new int [prices.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++){
            dp[i] = prices[i] - prices[i - 1];
            if(dp[i - 1] > 0){
                dp[i] += dp[i - 1];
            }
            if(max < dp[i]){max = dp[i];}
        }
        return max;
    }
}
}
