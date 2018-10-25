package leetcode;

public class Num297 {
    public class Codec {
        /**
         * 思路：采用前序遍历序列化和反序列化
         * 序列化格式：每个节点之间用空格隔开，用#表示null节点,*/
        // Encodes a tree to a single string.
        public int index;
        public String serialize(TreeNode root) {
            StringBuilder s = new StringBuilder();
            serializeHelper(root,s);
            return s.toString();
        }
        public void serializeHelper(TreeNode root,StringBuilder s){
            if(root == null){
                s.append("# ");
                return ;
            }
            s.append(root.val+" ");
            serializeHelper(root.left,s);
            serializeHelper(root.right,s);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String [] buf = data.split(" ");
            index = 0;
            TreeNode root = deserializeHelper(buf,index,buf.length);
            return root;
        }
        public TreeNode deserializeHelper(String [] buf,int i,int n){
            if(i == n){
                return null;
            }
            String str = buf[i];
            TreeNode root = null;
            if(!str.equals("#")){
                root = new TreeNode(Integer.parseInt(str));
                root.left = deserializeHelper(buf,++index,n);
                root.right = deserializeHelper(buf,++index,n);
            }
            return root;
        }
    }
}
