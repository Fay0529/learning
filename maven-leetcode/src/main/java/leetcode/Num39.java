package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Num39 {
    /*思路：
    * 递归搜索树进行枚举，递归的出口就是sum == level，可以将sum当递归的层数
    * 不过增长的步长不是1*/
    class Solution {
        int level = 0;
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        public void dfs(int [] canditates,int sum){
            if (sum == level){
                res.add(new LinkedList<>(tmp));
                return ;
            }
            if(sum > level){
                return ;
            }
            for (int i = 0; i <canditates.length;i++) {
                if(tmp.isEmpty()||tmp.get(tmp.size()-1) <= canditates[i]) {
                    tmp.add(canditates[i]);
                    dfs(canditates,sum+canditates[i]);
                    tmp.remove((Integer)canditates[i]);
                }
            }
        }
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            level = target;
            res.clear();
            dfs(candidates,0);
            return res;
        }
    }
    public static void main(String [] args){
        List<Integer> l = new LinkedList<>();
        l.add(10);
        l.add(2);
        l.add(2);
        l.remove((Integer)2);
        System.out.println(l);
    }
}
