package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num102 {
    /**
     * 树的层次遍历，采用队列即可*/
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> res = new LinkedList<>();
            if(root == null){
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int len = queue.size();
                List<Integer> tmp = new LinkedList<>();
                while(len > 0){
                    len--;
                    TreeNode p = queue.poll();
                    tmp.add(p.val);
                    if(p.left != null){
                        queue.offer(p.left);
                    }
                    if (p.right != null) {
                        queue.offer(p.right);
                    }
                }
                res.add(tmp);
            }
            return res;
        }
    }
}
