package leetcode;

import java.util.Stack;

public class Num98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 这题思路就是二叉搜索树的性质，它的中序遍历一定是升序序列
     * 这里复习下用栈来实现中序遍历，然后对中序遍历的序列进行升序判断
     */
    class Solution {

        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            TreeNode pre = null;
            while(p != null || !stack.empty()){
                while(p != null){
                    stack.push(p);
                    p = p.left;
                }
                if(!stack.empty()){
                    p = stack.pop();
                    if(pre != null && pre.val >= p.val){
                        return false;
                    }
                    pre = p;
                    p = p.right;
                }
            }
            return true;
        }
    }
}
