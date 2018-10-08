import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Num448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            /**
             * 思路：不用额外的空间，可直接利用nums的空间
             * 用i表示当前正在访问的元素的下标，初始为0.设最大值为N
             * 1.如果nums[nums[i]-1]的值不为N+1,则交换将nums[nums[i]-1]复制为N+1表示该元素出现过
             * 将nums[i]赋值为nums[nums[i]-1].i的值不变，继续访问nums[i]
             * 2.如果nums[nums[i]-1]的值为N+1,则i++;
             * 3.如果nums[i]为N+1,则i++
             * 遍历完一次所有元素后，再遍历一次nums，如果nums[i]小于N+1,则说明该元素没有出现过
             * 将i+1加入结果
             */
            List<Integer>res = new LinkedList<>();
            int i=0;
            int N = nums.length+1;
            while(i < nums.length){
                if(nums[i] == N || nums[nums[i]-1] == N){
                    i++;
                    continue;
                }
                int tmp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[tmp-1] = N;
            }
            for(int j = 0; j < nums.length; j++){
                if(nums[j] < N){
                    res.add(j+1);
                }
            }
            return res;


        }
    }
}
