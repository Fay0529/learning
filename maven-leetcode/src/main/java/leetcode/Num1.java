package leetcode;

public class Num1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            /*
            * 思路：这是个O(n*2)的算法，如果序列是有序的，还可以变成O(n)的算法
            * 所以本题可以变成O(nlog(n))的算法。现在的思路就是两重循环遍历，有序序列可遍历一次即可*/
            int [] res = new int [2];
            point:for (int i=0; i<nums.length-1; i++){
                for (int j = i+1; j<nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        res[0] = i;
                        res[1] = j;
                        break point;
                    }
                }
            }
            return res;
        }
    }
}
