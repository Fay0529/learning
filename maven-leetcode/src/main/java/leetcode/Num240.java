package leetcode;

public class Num240 {
    class Solution {
        /**
         * 思路：由于这个矩阵按行递增同时也按列递增，所以可以很好的利用这个性质
         * 让行数从第一行开始，列数从最后一列开始
         * 如果当前值比目标值大，那么需要减小当前值，只能让列数减小
         * 如果当前值比目标值小，那么需要增大当期值，只能让行数增加
         * 当行数或者列数超过范围时说明不存在*/
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix.length == 0 || matrix[0].length == 0){return false;}
            int x = 0;
            int y = matrix[0].length - 1;
            while(x < matrix.length && y >= 0){
                if(target == matrix[x][y]){return true;}
                if(target > matrix[x][y]){
                    x++;
                } else{
                    y--;
                }

            }
            return false;
        }
    }
}
