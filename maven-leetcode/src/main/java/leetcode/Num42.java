package leetcode;

public class Num42 {
    class Solution {
        public int trap(int[] height) {
            /**
             * 思路：两个指针left和right分别从数组左边和右边开始往中间遍历，
             * 用maxleft记录当前左边出现的最高高度
             * 用maxright记录当前右边出现的最高高度
             * 如果maxleft <= maxright，那么以左边为主，看看left当前的高度是否大于maxleft，
             * 如果小于，将当前高度补齐到maxleft，补齐的部分就是水，left++
             * 如果大于，将maxleft更新，left++
             * 以此类推*/
            if(height.length == 0){return 0;}
            int left = 0;
            int right = height.length-1;
            int maxleft = height[left];
            int maxright = height[right];
            int res = 0;
            while(left <= right) {
                if(maxleft <= maxright){
                    if(maxleft < height[left]){
                        maxleft = height[left];
                    } else{
                        res+= maxleft-height[left];
                    }
                    left++;
                } else{
                    if(maxright < height[right]){
                        maxright = height[right];
                    } else {
                        res+= maxright-height[right];
                    }
                    right--;
                }
            }
            return res;
        }

    }
}
