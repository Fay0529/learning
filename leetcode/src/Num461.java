public class Num461 {
    /**
     * 思路：两个数进行异或，然后统计1的个数*/
    class Solution {
        public int hammingDistance(int x, int y) {
            int z = x ^ y;
            int res = 0;
            while(z > 0){
                res += z % 2;
                z /= 2;
            }
            return res;
        }
    }
}
