package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Num3Test {

    @Test
    public void test(){
        Num3 n = new Num3();
        Num3.Solution s = n.new Solution();
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        int res1 = s.lengthOfLongestSubstring(test1);
        int res2 = s.lengthOfLongestSubstring(test2);
        int res3 = s.lengthOfLongestSubstring(test3);
        assertEquals(3,res1);
        assertEquals(1,res2);
        assertEquals(3,res3);
    }


}
