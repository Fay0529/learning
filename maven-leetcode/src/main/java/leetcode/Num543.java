package leetcode;

public class Num543 {
    class Solution {
        private int res = 0;
        /**
         * 思路：求树的高度用后序遍历，用一个函数求树的高度，这个函数是先求出两个子树的高度
         * 在返回根树的高度前，用一个全局变量记录左子树高度+右子树高度的最大值*/
        public int diameterOfBinaryTree(TreeNode root) {
            heightOfTree(root);
            return res;
        }
        public int heightOfTree(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = heightOfTree(root.left);
            int right = heightOfTree(root.right);
            res = Math.max(res,left+right);
            return Math.max(left,right)+1;
        }
    }
}
