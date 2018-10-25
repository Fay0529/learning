package leetcode;

public class Num114 {
    class Solution {
        /**
         * 思路：这个采用后序遍历方法，首先解决左子树，然后解决右子树，两个都解决后，
         * 找到左子树的最右子树，然后将根节点的右子树变成左子树的最右子树的右子树，
         * 将根节点左子树变成右子树*/
        public void flatten(TreeNode root) {
            if(root == null) return;
            flatten(root.left);
            flatten(root.right);
            TreeNode p = root.left;
            if(p != null) {
                // 如果左子树不为空，就找到左子树的最右子树
                while (p.right != null) {
                    p = p.right;
                }
                // 将右子树变成左字数的最右子树的右子树
                p.right = root.right;
                // 将左子树变成右子树
                root.right = root.left;
                // 将左子树清空
                root.left = null;
            }
        }
    }
}
