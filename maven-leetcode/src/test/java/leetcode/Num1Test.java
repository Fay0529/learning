package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Num1Test {
    @Test
    public void test(){
        Num1 num1 = new Num1();
        Num1.Solution solution = num1.new Solution();
        int [] nums={2,7,11,5};
        int res[] = solution.twoSum(nums,9);
        assertEquals(0,res[0]);
        assertEquals(1,res[1]);
    }
}
