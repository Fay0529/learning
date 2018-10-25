package leetcode;

public class Num647 {
    class Solution {
        private int res = 0;
        private void countPalindrome(String s ,int  i, int j){
            while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                res++;
                i--;
                j++;
            }
        }
        public int countSubstrings(String s) {
            /**
             * 从数据规模上看，这题可以用O(n^2)的算法
             * 求回文数可利用中心扩展的方法*/
            for(int i = 0; i < s.length(); i++){
                // 奇数情况
                countPalindrome(s,i,i);
                // even
                countPalindrome(s,i,i+1);
            }
            return res;
        }
    }
}
