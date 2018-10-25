package leetcode;

public class Num104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            /**
             * 思路：这题要统计树的高度，采用后序遍历的方法可统计树的高度、树节点的个数*/
            if(root == null){
                // 空树高度为零
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
        }
    }
}
