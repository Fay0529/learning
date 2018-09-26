public class Num96 {
    class Solution {
        /**
         * 这题给定了二叉搜索树的中序遍历的序列，问你有多少个这样的二叉树
         * 其实通过上一题关于中序遍历的非递归实现可以知道，中序遍历的和节点的入栈顺序是有关的
         * 所以这题其实就是问题有多少个入栈可能性，就是求卡特兰数，如果要返回所有这样的树，难度就增加了
         * 卡特兰数可用递推公式 cant[n] = cant[0]*cant[n-1] + cant[1]*cant[n-2] + ... + cant[n-1]*cant[0]
         */
        int []cant = new int[21];
        int catalan(int n){
            if(cant[n] > 0){
                return cant[n];
            }
            for(int i = 0; i < n; i++){
                cant[n] += catalan(i)*catalan(n - 1 - i);
            }
            return cant[n];
        }
        public int numTrees(int n) {
            cant[0] = cant[1] = 1;
            return catalan(n);
        }
    }
}
