import java.util.Queue;

public class Num64 {
    /**
     * 思路，动态规划问题，深度优先或者广度优先也可以，但是会超时
     * dp[i][j]表示走到i,j位置时的最小值，由于走到i,j的上一步要么是(i-1,j),要么是(i,j-1),
     * 由此得到递归公式
     * dp[i+1][j+1] = min(dp[i][j+1],dp[i+1][j])+grid[i+1][j+1] */
    class Solution {

        public int minPathSum(int[][] grid) {
            int [][]dp = new int[grid.length][grid[0].length];
            dp[0][0] = grid[0][0];
//            初始化
            for(int i = 1; i < dp.length; i++) {
                dp[i][0] = grid[i][0] + dp[i-1][0];
            }
            for (int j = 1; j < dp[0].length; j++){
                dp[0][j] = grid[0][j] + dp[0][j-1];
            }
            for(int i = 1; i < dp.length; i++){
                for (int j = 1; j < dp[0].length; j++){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
            return dp[grid.length - 1][grid[0].length - 1];
        }
    }
}
