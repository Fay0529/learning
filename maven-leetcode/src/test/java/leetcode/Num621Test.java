package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Num621Test {
    @Test
    public void test(){
        Num621 n = new Num621();
        Num621.Solution s = n.new Solution();
        char tasks[] = {'A','A','A','B','B','B'};
        int res = s.leastInterval(tasks,2);
        assertEquals(8,res);
    }

}
