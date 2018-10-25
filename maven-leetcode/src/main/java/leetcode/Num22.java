package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Num22 {
    class Solution {
        /**
         * 思路：这是个出栈可能性类的枚举问题
         * 用0代表左括号，1代表右括号，count[0]表示左括号剩余的数量
         * count[1]表示右括号剩余的数量，由于是递归搜索问题，确定搜索树的深度应该是2*n
         * 递归的出口就是当层数为2n时，将结果返回
         * 如果count[0]大于零，就可以将左括号入栈
         * 如果count[0]<count[1],那么就可以将右括号入栈*/
        List<String> res = new LinkedList<>();
        char [] str;
        int level;
        int []count= new int[2];
        void dfs(int d){
            if(d == level){
                res.add(String.valueOf(str));
                return;
            }
            if(count[0] > 0) {
                str[d] = '(';
                count[0]--;
                dfs(d+1);
//                回溯
                count[0]++;
            }
            if (count[1]>0 && count[0]<count[1]){
                str[d] = ')';
                count[1]--;
                dfs(d+1);
//                回溯
                count[1]++;
            }
        }
        public List<String> generateParenthesis(int n) {
            level = 2 * n;
            res.clear();
            count[0] = n;
            count[1] = n;
            str = new char [level];
            dfs(0);
            return res;
        }
    }
}
