package leetcode;

public class Num11 {
    /**
     * 思路：O(n)算法：
     * 两个指针分别指向最左边和最右边的竖线，刚开始桶的宽度是最大的
     * 然后减小桶的宽度，这时候，移动指向比较短的竖线的指针(宽度变小，高度可能增大)，因为移指向
     * 长的线的指针得出来的体积一定会比当前更小(宽度变小，高度不会增大）*/
    class Solution {
        public int maxArea(int[] height) {
            int i = 0,j = height.length - 1;
            int max = 0;
            while (i < j) {
                int h = height[i] > height[j] ? height[j] : height[i];
                int v = (j - i) * h;
                if (v > max) {
                    max = v;
                }
                if (height[j] > height[i]) {
                    i++;
                } else {
                    j--;
                }
            }
            return  max;
        }
    }
}
