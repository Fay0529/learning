package leetcode;

import java.util.HashMap;

public class Num128 {
    /** 题目要求o(n)的时间复杂度，在遍历到某个元素nums[i]时，我们需要在O(1)的时间复杂度内知道num[i]-1 或者nums[i]+1
     * 是否存在，可以用hashmap 去存与nums[i]-1相关的连续序列的长度left，以及num[i]+1相关序列的长度right，如果nums[i]没有出现过
     * 那么就可以直接将nums[i]相关的长度记为left+right+1,并且将nums[i]-left 和nums[i]+right 也更新为left+right+1;
     * 因为nums[i]已经将这两个连续序列连接起来了，后面只可能从序列的首和尾进行添加*/
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap();
            // res 记录结果
            int res = 0;
            for(int num : nums){
                if(!map.containsKey(num)){
                    int left = map.getOrDefault(num-1,0);
                    int right = map.getOrDefault(num+1,0);
                    int ans = left+right+1;
                    if(res < ans){
                        res = ans;
                    }
//                    将num相关的最长序列长度记录下来
                    map.put(num,ans);
//                    将num-left相关的序列长度记录下来，num-left就是整个序列的首
                    map.put(num-left,ans);
//                    讲num-right相关的序列长度记录下来，num+right就是整个序列的尾部
                    map.put(num+right,ans);
                }
            }
            return res;
        }
    }
}
