public class Num5 {
    class Solution {
        public String longestPalindrome(String s) {
            /**
             * 分别考虑奇数和偶数情况，
             * 对于奇数情况，可从一个中心出发往两边扩散
             * 对于偶数情况，可以从一个点和它相邻点开始往两边扩散*/
            if (s.length() <= 1) {
                return s;
            }
            // odd
            int oddLen = 0;
            int oddIndex = 0;
            int i = 0,j;
            while(i < s.length()) {
                // i 表示中心点的下标
                j = 0;
                while (i + j < s.length() && i - j >= 0) {
                    if (s.charAt(i + j) == s.charAt(i - j)) {
                        if (j * 2 + 1 > oddLen) {
                            oddLen = j * 2 + 1;
                            oddIndex = i;
                        }
                        j++;
                    } else {
                        break;
                    }

                }
                i++;
            }
            // even
            int evenLen = 0 ,evenIndex = 0;
            i = 0;
            while (i < s.length() - 1 ) {
                j = 0;
                while ( i - j >= 0 && i + j + 1 < s.length()) {
                    if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                        if (j * 2 + 2 > evenLen) {
                            evenLen = j * 2 + 2;
                            evenIndex = i;
                        }
                        j++;
                    } else {
                        break;
                    }
                }
                i ++;
            }
            if (oddLen > evenLen) {
                return s.substring(oddIndex - oddLen / 2,oddIndex + oddLen / 2 + 1);
            } else {
                return s.substring(evenIndex - evenLen / 2 + 1,evenIndex + evenLen / 2 + 1);
            }
        }
    }
}
