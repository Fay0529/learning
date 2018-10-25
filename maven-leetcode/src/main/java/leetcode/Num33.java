package leetcode;

public class Num33 {
    class Solution {

        public int search(int[] nums, int target) {
            /*思路：
            * 首先利用二分查找找到旋转点的坐标，也就是位置最小的元素的坐标
            * 找到旋转点后，就可以利用它进行正常的二分查找，正常二分查找的数组是递增的
            * 我们可以通过将正常二分查找的元素的位置进行位移得到它在旋转后数组中的位置
            */
            if (nums.length == 0) {
                return -1;
            }
            if (nums.length == 1 ) {
                if (nums[0] ==  target) {
                    return 0;
                } else {
                    return -1;
                }
            }
            int low=0,high = nums.length-1;
            int mid = 0;
            while(low <= high) {
                mid = (low + high) / 2;
                if (nums[mid] > nums[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1 ;
                }
            }
            int offset = low > 0?low -1 : 0;
            low = 0;
            high = nums.length - 1;
            int ans = 0;
            while(low <= high) {
                mid = (low + high) / 2;
                int realMid = (mid + offset) % nums.length;
                if (nums[realMid] == target){
                    ans = realMid;
                    break;
                } else if (nums[realMid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return ans;
        }
    }
    public static void main(String [] args){
        Num33 n = new Num33();
        Solution s = n.new Solution();
        int []array = {4,5,6,7,0,1,2};
        int ans = s.search(array,0);
        System.out.println(ans);
    }
}
