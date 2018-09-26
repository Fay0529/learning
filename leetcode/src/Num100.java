public class Num100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 思路，采用前序遍历的方式进行逐个节点判断，这里不能用前序遍历序列和中序遍历序列是否相等来判断
     * 以为会有重复元素*/

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p != null && q != null){
                if(p.val == q.val){
                    // 如果当前节点相同，则递归判断左子树和右子树是否相同
                    return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
                } else{
                    return false;
                }
            } else if(p == null && q == null){
                // 两棵空树是相同的
                return true;
            } else {
                // 如果一个为空一个不为空显然是不同的树
                return false;
            }

        }
    }
}
