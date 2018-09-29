public class Num169 {
    /**
     * 思路：count记录当前的最多出现的元素出现的次数，element记录这个元素
     * 遍历这个数组，如果当前值等于element，则count++，否则，count--,如果当前count已经小于0了，就将count = 1，element = 当前值
     * 最后的element为主元素*/
    class Solution {
        public int majorityElement(int[] nums) {
            int element = nums[0];
            int count = 1;
            for(int i = 1; i < nums.length; i++){
                if(nums[i] == element){count++;}
                else {
                    count --;
                    if(count < 0){
                        count = 1;
                        element = nums[i];
                    }
                }
            }
            return element;

        }
    }
}
