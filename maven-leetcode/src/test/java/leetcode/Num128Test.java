package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Num128Test {
    @Test
    public void test(){
        Num128 n = new Num128();
        Num128.Solution s = n.new Solution();
        int []input = {100,4,200,1,3,2};
        int output = 4;
        assertEquals(output,s.longestConsecutive(input));
    }
}
