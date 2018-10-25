package leetcode;

public class Num226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            /**exchange each tree's left child and right child recursively*/
            if( root == null){return root;}
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
