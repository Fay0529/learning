public class Num337 {
    /**
     * 思路：对于一棵树来说，它的根节点可以被偷可以不被偷
     * 分这两种情况处理，这题主要采用递归枚举的方式去做*/
    class Solution {
        public int robHelp(TreeNode root, boolean isInclude){
           if(root == null) {return 0;}
            if(isInclude)
            {
                //如果包含根节点
                return root.val+robHelp(root.left,false)+robHelp(root.right,false);
            } else {
                // 如果不包含根节点，那么它的子树就没有限制
                return rob(root.left)+rob(root.right);
            }

        }
        public int rob(TreeNode root) {
            if(root == null){return 0;}
            return Math.max(robHelp(root,true),robHelp(root,false));
        }
    }
}
