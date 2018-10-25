package leetcode;

public class Num437 {
    class Solution {
        /**
         * 思路：采用递归遍历的方式去做的，用全局变量count来记录总的路径数量
         * 用include来记录父节点有没有在路径中，如果父节点在路径中，那么子女节点必须在路径中，否则路径就是断开的
         * 如果父节点不在路径中，那么子女节点既可以在路径中也可以不在路径中*/
        private int count = 0;
        private boolean include = false;
        public int pathSum(TreeNode root, int sum) {
            if(root==null){return 0;}
            if(sum - root.val == 0){
                // 如果该节点加入后使得正好和为sum，则这条路径记录下来
                count ++;
            }
            if(include == false) {
                // 如果父节点不在路径中
                include  = true;
//                本节点可以在路径中，将include记为true
                pathSum(root.left, sum - root.val);
                pathSum(root.right, sum - root.val);
//                本节点可以不在路径中，将include记为false
                include = false;
                pathSum(root.left, sum);
                pathSum(root.right, sum);
            } else{
                // 如果父节点在路径中，则子节点只能在路径中了
                pathSum(root.left, sum - root.val);
                pathSum(root.right, sum - root.val);
            }
            return count;
        }
    }
}
