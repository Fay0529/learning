public class Num236 {
    class Solution {
        /**
         * 思路：如果当前节点包含其中一个数，那么当前节点就是最小的祖先
         * 如果两个数分别在当前节点的左右两棵树中，那么当前节点也是最小祖先
         * 如果两个数在同一颗树种，那么就递归它的 子树*/
        boolean contains(TreeNode root,int value){
            if(root == null){return false;}
            if(root.val == value){return true;}
            else return contains(root.left,value)||contains(root.right,value);
        }
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root.val == p.val || root.val == q.val ){
                return root;
            }
            boolean leftContainsP = contains(root.left,p.val);
            boolean leftContainsQ = contains(root.left,q.val);
            if(leftContainsP ^ leftContainsQ){return root;}
            if(leftContainsP){
                return lowestCommonAncestor(root.left,p,q);
            } else{
                return lowestCommonAncestor(root.right,p,q);
            }
        }
    }
}
