package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Num94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 思路：用栈来代替递归算法，每遍历一个节点，先将其压入栈中，然后访问它的左子树
     * 如果左子树为空，就从栈中弹出一个节点，然后访问，接着访问它的子树
     * 如果右子树为空，说明这个根节点的树访问完了,如果此时栈不为空，从栈中拿出上层节点继续访问
     * 否则就整棵树访问完了*/
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer>res = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            while(p!=null){
                while(p!=null){
                    stack.push(p);
                    p = p.left;
                }
                if(!stack.empty()){
                    p = stack.pop();
                    res.add(p.val);
                    p = p.right;
                } else{
                    return res;
                }
            }
            return res;

        }
    }
}
