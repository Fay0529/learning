package leetcode;

public class Num617 {
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            /**
             * 思路：采用前序遍历递归进行合并*/
            if(t1 == null && t2 == null){return null;}
            else if(t1 == null && t2 != null){
                return t2;
            } else if (t1 != null && t2 == null){
                return t1;
            } else{
                t1.val += t2.val;
                t1.left = mergeTrees(t1.left,t2.left);
                t1.right = mergeTrees(t1.right,t2.right);
                return t1;
            }
        }
    }
}
