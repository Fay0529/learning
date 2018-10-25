package leetcode;

public class Num309 {
    /**
     * 思想：这题动态规划有点难，看了别人的答案用了状态转换图是个不错的方法
     * s0为初始状态，它可以由s0状态进行rest得到，也可以由s2(卖后的状态）通过rest得到
     * s1为买后的状态，它可以由s0状态花钱买股票得到，也可以由s1自己rest得到
     * s2为卖后的状态，它可以由s1状态卖股票得到，它本身不能rest得到，因为rest直接就回到了s0状态*/
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length < 2){return 0;}
            int []s0 = new int[prices.length];
            int []s1 = new int[prices.length];
            int []s2 = new int[prices.length];
            s0[0] = 0;
            s1[0] = -prices[0];
            s2[0] = 0;
            for(int i =1; i < prices.length; i++){
                s0[i] = Math.max(s0[i-1],s2[i-1]);
                s1[i] = Math.max(s0[i-1]-prices[i],s1[i-1]);
                s2[i] = s1[i-1]+prices[i];

            }
            return Math.max(s0[s0.length-1],s2[s2.length-1]);
        }
    }
}
