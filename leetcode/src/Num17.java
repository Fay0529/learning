import java.util.LinkedList;
import java.util.List;

public class Num17 {
    /***
     * 思路，采用递归暴力搜索
     * */

    class Solution {
        // level 记录递归层数，作为递归出口判断
        int level;
        // str[] 暂存结果
        char [] str;
        String getString(char c){
            // 该函数根据c的值来获取可能的字符
            String res = null;
            switch(c){
                case '2':
                    res = "abc";
                    break;
                case '3':
                    res = "def";
                    break;
                case '4':
                    res = "ghi";
                    break;
                case '5':
                    res = "jkl";
                    break;
                case '6':
                    res = "mno";
                    break;
                case '7' :
                    res ="pqrs";
                    break;
                case '8':
                    res = "tuv";
                    break;
                case '9':
                    res = "wxyz";
                    break;
                default:
                    res = null;
            }
            return res;
        }
        List<String> res = new LinkedList<>();
        void dfs(String digits,int cur){
            if (cur == level){
                res.add(String.valueOf(str));
                return ;
            }
            char c = digits.charAt(cur);
            String option = getString(c);
            for(int i = 0;i < option.length(); i++){
                str[cur] = option.charAt(i);
                dfs(digits,cur+1);
            }
        }
        public List<String> letterCombinations(String digits) {
            res.clear();
            level = digits.length();
            if (level == 0){
//                level == 0返回空list
                return res;
            }
            str = new char[level];
            dfs(digits,0);
            return res;
        }
    }
}
