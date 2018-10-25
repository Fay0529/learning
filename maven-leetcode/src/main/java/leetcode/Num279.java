package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num279 {
    class Solution {
        /**
         * 思路：使用动态规划的思想
         * 题目是相当于01背包问题的一种变形
         * 比目标数小的平方数可以当做物体，它的值就是物体的体积，目标数就是背包容量
         * 只不过这里要最小化价值，也就是物体的个数，每个物体的价值为1*/
        public List<Integer> res = new ArrayList<>();
        {
            res.add(0);
        }
        public int numSquares(int n) {
            if(n <= 0){return 0;}
            if(n >= res.size()){
                while(n >= res.size()){
                    int sz =res.size();
                    int tmp = Integer.MAX_VALUE;
                    for(int i = 1; i*i <= sz; i++){
                        // dp[i][j] = min (dp[i-1][j],dp[i-1][j-val]+1)
                        tmp = Math.min(tmp,res.get(sz- i*i) + 1);
                    }
                    res.add(tmp);
                }

            }
            return res.get(n);
        }
    }
}
