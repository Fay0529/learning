package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Num438 {
    class Solution {
        /**
         * 这里由于字符串可能很长，如果每次都从头到尾比较会很慢
         * 所以采用hash，统计每个字母出现的次数比较一次字符串相等的时间是常数级的
         * 并且随着窗口的滑动，窗口内的hash数组变动只需要更改两个字母的就可以*/
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer>res = new LinkedList<>();
            int sLen = s.length();
            int pLen = p.length();
            if(pLen > sLen){return res;}
            int [] pCount = new int[26];
            int [] sCount = new int[26];
            for(int i=0; i<pLen; i++){
                pCount[p.charAt(i)-'a']++;
                sCount[s.charAt(i)-'a']++;
            }
            int j = 0;
            while(j < sLen - pLen){
                boolean flag = true;
                for(int i = 0; i < 26; i++){
                    if(pCount[i]!=sCount[i]){
                        flag = false;
                        break;
                    }
                }
                if(flag){res.add(j);}
                if(j < sLen - pLen){
                    sCount[s.charAt(j)-'a']--;
                    sCount[s.charAt(j+pLen)-'a']++;
                }
                j++;

            }
            return res;
        }
    }

}
