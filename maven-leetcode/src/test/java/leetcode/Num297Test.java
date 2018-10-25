package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Num297Test {
    @Test
    public void test(){
        Num297 n = new Num297();
        Num297.Codec codec = n.new Codec();
        String str = "1 2 # # 3 4 5 # # # # ";
        TreeNode root = codec.deserialize(str);
        String res = codec.serialize(root);
        assertEquals(str,res);
    }
}
