package leetcode;

public class Num283 {
    class Solution {
        /**
         * 思路：用数组count[0]来统计当前元素前面0的个数，如果当前元素就是0，那么count0[i]++
         * 统计完成后，只需要将不为0的元素往前位移count0[i]位，然后将后面的元素填充为0即可*/
        public void moveZeroes(int[] nums) {
            int []count0 = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                int before;
                if(i == 0){before = 0;}
                else{before=count0[i-1];}
                if(nums[i] == 0){
                    count0[i] = before + 1;
                } else{
                    count0[i] = before;
                }
            }
            for(int i = 0; i < nums.length; i++){
                if(nums[i]!=0){
                    nums[i-count0[i]] = nums[i];
                }
            }
            for(int i = nums.length-count0[nums.length-1]; i < nums.length; i++){
                nums[i]=0;
            }
        }
    }
}
