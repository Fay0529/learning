package leetcode;

public class Num572 {
    class Solution {

        public boolean isSameTree(TreeNode t1,TreeNode t2){
            if(t1 == null && t2 == null){
                return true;
            } else if(t1 == null ^ t2 ==null){
                return false;
            } else{
                if(t1.val != t2.val){
                    return false;
                } else{
                    return isSameTree(t1.left,t2.left) && isSameTree(t1.right,t2.right);
                }
            }
        }
        public boolean isSubtree(TreeNode s, TreeNode t) {
//            如果 t为空，空树默认是s的子树
            if(t == null){return true;}
//            否则，如果s为空t不为空，那么t一定不是s的子树
            else if(s == null){
                return false;
            } else {
//                如果s和t均不为空，那么看看s和t是不是同一颗树
                if(isSameTree(s,t)){
                    return true;
                } else{
//                    如果s和t不是同一颗树，那么看看 t是不是s的左子树或者右子树
                    return isSubtree(s.left,t) || isSubtree(s.right,t);
                }
            }

        }
    }
}
