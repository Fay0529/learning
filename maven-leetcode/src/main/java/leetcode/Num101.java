package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num101 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 思路：树的层次遍历，利用队列来实现，判断每一层的数据是否对称
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int len = q.size();
                if(len % 2 != 0){
                    return false;
                }
                List<Integer> l = new ArrayList<>();
                while(len > 0){
                    len --;
                    TreeNode tmp = q.poll();
                    if(tmp != null){
                        l.add(tmp.val);
                        q.add(tmp.left);
                        q.add(tmp.right);
                    } else {
                        l.add(null);
                    }
                }
                int sz = l.size();
                for(int i = 0; i < sz; i++){
                   if(l.get(i)!=null && l.get(sz - 1 -i) != null && l.get(i).equals(l.get(sz - 1 -i))
                   || l.get(i) == null && l.get(sz - 1 -i) == null){
                       continue;
                   }
                    return false;
                }
            }
            return true;

        }
    }
}
