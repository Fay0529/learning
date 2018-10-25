package leetcode;

public class Num35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int high = nums.length -1;
            int low = 0;
            int mid = -1;
            while(low <= high){
                mid = (low + high) / 2;
                if (nums[mid] > target) {
                    high = mid - 1;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    break;
                }
            }
            if (low <= high) {
                return mid;
            } else {
                return low;
            }

        }
    }
}
