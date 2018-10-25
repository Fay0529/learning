package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Num42Test {
    @Test
    public void test(){
        Num42 n = new Num42();
        Num42.Solution s = n.new Solution();
        int [] input= {0,1,0,2,1,0,1,3,2,1,2,1};
        int output=6;
        assertEquals(output,s.trap(input));
    }
}
