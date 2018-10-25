package leetcode;

public class Num312 {
    /***
     * 采用分治的方法去实现，对下标1~n的气球，给定它的边界nums[0] = 1,nums[n+1] = 1
     * 假设最后一次选择的是第i个气球，将原来的区间划分为[0,i] ,[i,n+1],最后一个气球一定是和边界相乘的
     * 这里i成了两个子区间的边界，因为前面的选择中i是一直存在的。
     * 可以用一个数组来记录递归的结果，假设函数func(i,j)能够求出来区间[i,j]的最优解
     * 那么最终的最优解就是max(nums[left]*nums[i]*nums[righty]+func(0,i)+func(i,n+1);
     * （1 <= i <= n)
     */
    class Solution {
//        mem[i][j]用来记录区间i 到区间 j的结果，用来剪枝
        int [][] mem;
        private int [] nums;

        public int maxCoins(int [] nums) {

//            buffer用来记录增加边界后的情况
            int [] buffer = new int [nums.length+2];
            this.nums = buffer;
            int i = 1;
            for(int x : nums){buffer[i++] = x;}
            buffer[0] = 1;
            buffer[i++] = 1;
            mem = new int[i][i];
            return func(0,i-1);
        }

        /**
         * @param left 区间的开始（边界）
         * @param right 区间的结束（边界）
         * @return 返回从区间i到区间j的最优解
         */
        public int func(int left ,int right){
//            如果结果已经求出来了，就直接返回
            if(mem[left][right] > 0){
                return mem[left][right];
            }
//            如果左边界右边就是右边界，说明已经没有气球了
            if(left+1 == right){
                return 0;
            }
            int ans = 0;
//            遍历所有气球，尝试将他们作为最后一次扎破的气球并进行分区间，得到最大的结果
            for(int i = left+1; i < right; i++){
                ans = Math.max(ans,func(left,i)+func(i,right)+nums[i]*nums[left]*nums[right]);
            }
//            记录结果到mem，用来剪枝
            mem[left][right] = ans;
            return ans;
        }

    }


}
