package leetcode;

public class Num221 {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            /**
             * dp[0][i] = matrix[0][i] ;
             * dp[i][0] = matrix[i][0];
             * (i > 0, j > 0) if(matrix[i][j] == 0) dp[i][j] = 0;
             * if (matrix[i][j] == 1) dp[i][j] = min (dp[i][j-1],dp[i-1][j],dp[i-1][j-1]) + 1*/
            if(matrix.length == 0){return 0;}
            int  [][]dp = new int[matrix.length][matrix[0].length];
            int max = 0;
            for(int i = 0; i < dp.length; i++){
                dp[i][0] = matrix[i][0] - '0';
                if(max < dp[i][0])max = dp[i][0];
            }
            for(int i = 0; i < dp[0].length; i++){
                dp[0][i] = matrix[0][i] - '0';
                if(max < dp[0][i])max = dp[0][i];
            }
            for(int i = 1 ; i < dp.length; i++){
                for(int j = 1; j < dp[0].length; j++)
                {
                    if(matrix[i][j] == '0'){
                        dp[i][j] = 0;
                    } else{
                        int a = Math.min(dp[i-1][j],dp[i][j-1]);
                        dp[i][j] = Math.min(a,dp[i-1][j-1])+ 1;
                        if(dp[i][j] > max){
                            max = dp[i][j];
                        }
                    }

                }
            }
            return max*max;
        }
    }
}
