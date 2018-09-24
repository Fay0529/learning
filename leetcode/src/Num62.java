import java.math.BigInteger;

public class Num62 {
    class Solution {
        /**
         * 这是个排列组合数的问题，排列组合数可能比较大，而且题目中是不能用BigInteger的
         * 所以要么手动实现各BigInteger，要么采用递推的方法去求组合数
         * 用递归算法去实现时，主要的问题是剪枝，否则会栈溢出，这里用个数组buf来存储已经得到
         * 的结果，对得到的结果直接取值，不再进行递归*/
        int [][]buf = new int [1000][1000];
        int combination(int m,int n){
           if(n == 0||m == 1 || m == n){
               return 1;
           }
           if (buf[m-1][n-1] == 0){
               buf[m-1][n-1] = combination(m - 1, n - 1);
           }
           if (buf[m - 1][n] == 0){
               buf[m - 1][n] = combination(m - 1,n);
           }
           return buf[m-1][n-1]+buf[m - 1][n];

        }
        public int uniquePaths(int m, int n) {
            if (m == 1 || n == 1) {
                return 1;
            }
            int min = m > n? n : m;
            return combination(m + n - 2,min - 1);
        }
    }
}
