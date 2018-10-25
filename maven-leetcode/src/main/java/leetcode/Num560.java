package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num560 {
    class Solution {
        /**
         * 思路：这题的数组达到2万规模，时间复杂度应该不能超过O(nlogn),而这题与二分应该无关，所以考虑O(n)的算法
         * 因为数组的连续子数组有(n+1) * n / 2 ，常常遍历一遍数组记录前i个数的和，利用sum[j] - sum[i] 得到下标i+1 到 j的子数组的和
         * 这里定位i 从而使 sum[j] - sum[i] = k ，采用从0 到 j 的方式去遍历就相当于暴力求解，时间复杂度O(n^2)
         * java中有hashmap 可以直接在O(1)时间复杂度内找到是否含有满足的sum[i]*/
        public int subarraySum(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            map.put(0,1);
            int sum = 0;
            int res = 0;
            for(int i = 0; i < nums.length; i++){
                sum+= nums[i];
                if(map.containsKey(sum - k)){
                    // 这里和为sum - k 的可能有多个，以i个元素结尾的子数组中， i前面有多少个sum[j] 满足 sum[i] - sum[j] = k,那就有几个以i结尾的满足条件的子数组
                    res += map.get(sum - k);
                }
                // 更新sum出现的次数
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
            return res;

        }
    }
}
