public class Num48 {
    class Solution {
        /**
         * 思路：四个点四个点的旋转，开始是四个顶点，然后是下一组，找到这几个点间的位置关系
         * 搞清楚涉及到matrix[i][j]的四个点相对于 matrix[i][j]的位置分别是什么
         * */

        public void rotate(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix.length;
            for (int i = 0; i < rows/2; i++) {
                for (int j = i; j < cols - i - 1; j++){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[rows - 1 - j][i];
                    matrix[rows - 1 - j][i] = matrix[rows - 1 -i][cols - 1 - j];
                    matrix[rows - 1 -i][cols - 1 - j] = matrix[j][cols - i - 1];
                    matrix[j][cols - i - 1] = tmp;
                }
            }
        }
    }
}
