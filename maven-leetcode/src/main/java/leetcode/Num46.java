package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Num46 {
    /*这是个全排列问题，典型的递归搜索树，层数即为数组的个数，因为每个元素只能被用一次，因此要
    * 用一个数组记录哪些元素已经被用了*/

    class Solution {
        boolean []mark;
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        int level;

        /**
         * @param nums 给的序列
         * @param d 当前递归层数
         */
        void dfs(int[] nums,int d) {
            if(d == level) {
                res.add(new LinkedList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if( mark[i] == false) {
                    tmp.add(nums[i]);
                    mark[i] = true;
                    dfs(nums,d+1);
                    tmp.remove((Integer)nums[i]);
                    mark[i] = false;
                }
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            level = nums.length;
            res.clear();
            tmp.clear();
            mark = new boolean[level];
            dfs(nums,0);
            return res;
        }
    }
}
