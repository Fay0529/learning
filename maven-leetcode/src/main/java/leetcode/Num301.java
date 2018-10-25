package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num301 {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<>();
            remove(s, ans, 0, 0, new char[]{'(', ')'});
            return ans;
        }

        /**
         * 整个函数采用递归求解
         * @param s 当前被处理的字符串
         * @param ans 存储结果的列表
         * @param last_i 上次被访问到的字符位置
         * @param last_j 上次被删掉的字符位置
         * @param par 存储左右括号，par[0]是数量少的那个，par[1]是数量多的那个
         */
        public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
            for (int stack = 0, i = last_i; i < s.length(); ++i) {
                // 如果是数量少的那个，stack++
                if (s.charAt(i) == par[0]) {
                    stack++;
                }
                // 如果是数量多的那个，stack--
                if (s.charAt(i) == par[1]) {
                    stack--;
                }
                if (stack >= 0) {
                    continue;
                }
                // 如果stack<0 说明当前这个par[1]正好是多余的
                // 从上一个删除的位置开始，到当前位置进行枚举删除
                for (int j = last_j; j <= i; ++j) {
                    // 可以删除上一个删除的位置（注意由于上一个删除的位置的元素已经被删除，所以实际上是上一个删除位置的下一个
                    // 或者删除连续两个相同par[1]的第一个par[1]，防止重复
                    if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                        // 删除完后，对删除后的字符串进行进一步求解，传入本次删除的位置以及本次访问到的位置
                        remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                    }
                }
                return;
            }
            // 如果last_i已经等于s.length()将不会进入循环，这个时候可能是因为par[0]此时要比par[1]多，所以stack一直>=0,
            // 需要颠倒一下字符串顺序来，并且颠倒par[0] 和 par[1]的顺序再次用相同方法求解
            String reversed = new StringBuilder(s).reverse().toString();
            // finished left to right
            // 默认par[0] = '(',为了保证只颠倒一次，这里加上if
            if (par[0] == '(') {
                remove(reversed, ans, 0, 0, new char[]{')', '('});
            } else {
                // 如果已经是颠倒过的了，那么就不需要再颠倒，这个子问题求解结束
                // finished right to left
                ans.add(reversed);
            }
        }
    }
}
