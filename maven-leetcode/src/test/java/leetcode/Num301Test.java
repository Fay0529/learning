package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Num301Test {
    @Test
    public void test(){
        Num301 n = new Num301();
        Num301.Solution s = n.new Solution();
        String [] input = {"()())()","(a)())()",")("};
        List res = s.removeInvalidParentheses(input[0]);
        List output = Arrays.asList("()()()","(())()");
        Collections.sort(output);
        Collections.sort(res);
        assertEquals(res,output);
    }
}
