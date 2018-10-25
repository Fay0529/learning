package leetcode;

public class Num75 {
    /**
     * 题目要求one-pass，这种方法我的思路是用两个指针分别指向0和2应该放的位置p1,p2，然后
     * 从头到尾遍历一次，遇到0并且当前位置在p1后面，就交换p1和当前位置的值，然后让p1指针指向下一个位置（第一个大于0的位置）
     * 遇到2并且当前位置在p2前面，就交换p2和当前位置的值，p2指向第一个小于2的位置
     * 遇到1，则不处理
     * 如果本次没有发生交换，就遍历下一个元素*/

    class Solution {

        public void sortColors(int[] nums) {
            int p1 = 0,p2 = nums.length - 1;
            boolean swap = false;
            // 初始化p1,p2的位置
            while(p1 < nums.length && nums[p1] == 0) {
                p1 ++;
            }
            while(p2 > 0 && nums[p2] == 2){
                p2 --;
            }
            for (int i = 0; i < nums.length;) {
                swap = false;
                if (nums[i] == 0 && i > p1){
                    swap = true;
                    int t = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = t;
                    while(p1 < nums.length && nums[p1] == 0) {
                        p1 ++;
                    }
                }
                if (nums[i] == 2 && i < p2){
                    swap = true;
                    int t = nums[i];
                    nums[i] = nums[p2];
                    nums[p2] = t;
                    while(p2 > 0 && nums[p2] == 2){
                        p2 --;
                    }
                }
                if (swap == false) {
                    i ++;
                }
            }
        }
    }
}
