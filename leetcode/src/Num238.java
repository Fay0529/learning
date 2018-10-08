public class Num238 {
    class Solution {
        /**
         * 思路：可以发现每个数的形式是1x2x..xi-1   x   (i+1)x(i+2)x..n
         * 左边部分会随着i的增大而增长，让右边则恰好相反，所以可以先求出左边的部分，
         * 再乘上剩余的部分*/
        public int[] productExceptSelf(int[] nums) {
            int []output = new int[nums.length];
            output[0] = 1;
            // now let output[i] be nums[0] * nums[1] * ... * nums[i-1]
            for(int i = 1; i < nums.length; i++){
                output[i] = output[i-1] * nums[i-1];
            }
            // we know that output[i] must be nums[0] * ...* nums[i-1] * nums[i+1]...nums[n-1]
            // let us multi the rest
            int rest = 1;
            for(int i = nums.length - 1; i > -1; i-- ){
                output[i] *= rest;
                rest *= nums[i];
            }
            return output;
        }
    }
}
