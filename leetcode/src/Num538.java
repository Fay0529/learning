public class Num538 {
    class Solution {
        /**
         * RVL中序遍历会得到一个逆序的序列，遍历过程中记录下来遍历过的点的值的和
         * */
        private int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            if(root == null){return null;}
            // 先遍历右子树
            convertBST(root.right);
            // 当前节点加上前面的数的和
            root.val+=sum;
            // 更新sum
            sum = root.val;
            // 再遍历左节点
            convertBST(root.left);
            return root;
        }
    }
}
