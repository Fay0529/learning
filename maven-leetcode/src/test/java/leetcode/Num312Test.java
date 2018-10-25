package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Num312Test {
    @Test
    public void func(){
        Num312 n = new Num312();
        Num312.Solution s = n.new Solution();
        int [] input = {3,1,5,8};
        int output = 167;
        assertEquals(output,s.maxCoins(input));
    }
}
