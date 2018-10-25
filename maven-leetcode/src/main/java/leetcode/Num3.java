package leetcode;

public class Num3 {
    class Solution {
        /**
         * 问题思路，设两个指针i,j,curtLen记录当前的子串长度
         * maxLen记录最大子串长度，开始时j=i+1,curLen=1.
         * 如果位置j的字符与位置i的不同,则curLen++,j++.否则假设j与
         * k位置的元素重复，那么令i=k+1,j++,curLen = j-i;继续上述操作
         * */
        //check 函数检查字符串s 从i 到 j这一段是否有重复，如果有重复返回和j重复的位置，如果没有返回-1
        public int check(String s,int i, int j) {

            int k = -1;
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    k = i;
                    break;
                }
                i++;
            }
            return k;
        }
        public int lengthOfLongestSubstring(String s) {
            int i = 0,j = 1;
            int maxLen = 0;
            int curLen = 1;
            if (s.length() <= 1) {
                return s.length();
            }
            while (j < s.length()) {
                int k = check(s,i,j);
                if (k == -1) {
                    curLen ++;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                    }
                } else {
                    i = k + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                    }
                    curLen = j - i + 1;
                }
                j++;
            }
            return maxLen;
        }
    }
}
