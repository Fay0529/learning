package leetcode;

public class Num34 {
    class Solution {
        /*思路：
        * 简单的二分查找，找到之后向两边扩散找到边缘的下标即可*/
        public int[] searchRange(int[] nums, int target) {
            int low,high;
            low = 0;
            high = nums.length - 1;
            // flag 用来判断是否找到
            boolean flag = false;
            int []res = new int[2];
            int mid = -1;
            while(low <= high){
                mid = (low + high) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                res[0] = res[1] = mid;
                while(res[0] > 0 && nums[res[0]] == nums[res[0] - 1]){
                    res[0]--;
                }
                while(res[1] < nums.length - 1 && nums[res[1] + 1] == nums[res[1]]){
                    res[1]++;
                }
            } else {
                res[0] = res[1] = -1;
            }
            return res;
        }
    }
}
