package leetcode;

import java.util.Arrays;

public class Num581 {
    class Solution {
        /**
         * 这题就是要找到一个最短的子序列，使得子序列左边的数不大于子序列最小的数，右边的数不小于子序列最大的数
         * 并且子序列左边的序列和右边的序列是升序的。这题规模达到1万，只能用O(nlogn)以下的时间复杂度
         * 这里想出的O(nlogn)复杂度的算法是：先对原数组进行排序，然后从左到右找到第一个两个数组不相等的位置i
         * 从右到左找到第一个不相等的位置j(j >=i) j-i+1 即为所求
         * 这个算法空间复杂度O(n)
         * */
        public int findUnsortedSubarray(int[] nums) {
            int [] tmp = nums.clone();
            Arrays.sort(tmp);
            int i = 0;
            int j = nums.length - 1;
            while(i < nums.length){
                if(tmp[i] == nums[i]){i++;}
                else{break;}
            }
            if(i == nums.length){return 0;}
            while(j > i){
                if(tmp[j] == nums[j]){j --;}
                else{break;}
            }
            return j - i + 1;
        }
    }
}
