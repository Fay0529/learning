public class Num300 {
    class Solution {
        /**
         * 最大上升子序列问题，普通的dp就可以达到O(n^2)的要求
         * 至于O(nLog(n))的算法，使用dp数组来存储当前的最大上升子序列
         * 对于每个节点，利用二分查找的方法，找到它在dp中应该插入的位置
         * 如果位置不是数组的最后，那么就将那个位置的元素替换为当前元素
         * 如果是数组的最后，那么就将数组长度加1，将当前元素加到数组的后面
         * 最后数组的长度就是最大上升子序列
         * * */
        public int lengthOfLIS(int[] nums) {
            if(nums.length==0){return 0;}
            int []dp = new int[nums.length];

            int max = 1;
            for(int i = 0; i < dp.length; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j ++){
                    if(nums[j] < nums[i]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                if(dp[i] > max){
                    max = dp[i];
                }
            }
            return max;
        }
    }
}
