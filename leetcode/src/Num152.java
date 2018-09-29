public class Num152 {
    class Solution {
        public int maxProduct(int[] nums) {
            /**思路：这题同样也是动态规划，但是由于有负数的存在，使得题目难度变大
             * 用imin表示以nums[i]结尾的子序列的最下积，用imax表示以num[i]结尾的子序列最大的积,
             * 那么经过迭代imin一定是小于等于零的，而imax一定是大于等于零的。所以
             * 如果num[i+1]为非负数，那么下一次迭代时，imax = max(nums[i+1],nums[i+1]*imax) //正数乘正数还是正数
             * 如果nums[i+1]为负数，那么下一次迭代时，imax = max(nums[i+1],nums[i+1]*imin) //负数乘负数得正
             * 同理imin也是*/
            int max = nums[0];
            int imax = max;
            int imin = max;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] < 0){
                    // 负数就交换imax 和 imin
                    int t = imax;
                    imax = imin;
                    imin = t;
                }
                imax = Math.max(nums[i],nums[i]*imax);
                imin = Math.min(nums[i],nums[i]*imin);
                if(max < imax){
                    max = imax;
                }
            }
            return max;
        }
    }
}
