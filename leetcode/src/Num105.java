import java.util.Arrays;

public class Num105 {
    /**
     * 这题要根据前序遍历和后序遍历的序列来构建树，可采用递归的方法构建
     * 首先找到前序遍历的第一个元素，它就是这棵树的根，然后在中序序列中找到这个根元素的位置i
     * 在中序序列中，[0,i-1]是左子树的中序序列，[i+1,end]是右子树的中序序列
     * 在前序序列中，[1,i]是左子树的前序序列，[i+1,end]是右子树的前序序列
     * 得到了左右子树的前序、中序序列，可根据这两个序列递归构造左右子树*/
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length == 0) {
//                前序序列为空，则返回null
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);
            // 在中序序列中找到根节点的位置i
            int i;
            for(i = 0; i < inorder.length; i++){
                if (inorder[i] == preorder[0]){
                    break;
                }
            }
            if( i > 0){
                // i > 0 ,说明有左子树
                int [] leftPreOrder = Arrays.copyOfRange(preorder,1,i + 1);
                int [] leftInOrder = Arrays.copyOfRange(inorder,0,i + 1);
                root.left = buildTree(leftPreOrder,leftInOrder);
            }
            if ( i < inorder.length - 1){
                // 说明有右子树
                int [] rightPreOrder = Arrays.copyOfRange(preorder,i + 1,preorder.length);
                int [] rightInOrder = Arrays.copyOfRange(inorder,i + 1,inorder.length);
                root.right = buildTree(rightPreOrder,rightInOrder);
            }
            return root;

        }
    }
}
