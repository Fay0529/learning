package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Num78 {
    class Solution {
        /**
         * 思路：这是个枚举所有子集的问题，对于每个元素都有取或者不取两种可能
         * 本题我采用递归枚举的思路，层数为nums的长度*/
        int level;
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        private int[] nums;

        /**
         * @param d d 表示当前的深度
         */
        void dfs (int d){
            if (level == d) {
                res.add(new LinkedList<Integer>(tmp));
                return;
            }
            // 放入
            tmp.add((Integer)nums[d]);
            dfs(d+1);
            // 不放入
            tmp.remove((Integer)nums[d]);
            dfs(d+1);
        }
        public List<List<Integer>> subsets(int[] nums) {
            level = nums.length;
            this.nums = nums;
            res.clear();
            tmp.clear();
            dfs(0);
            return res;
        }
    }
}
