public class Num208 {
    /**
     * 本题的思想是字典树，我才用比较简单粗暴的固定长度数组来实现每一层的节点*/
    class Trie {

        /** Initialize your data structure here. */
//        每个节点的类
        class Node{
            public boolean isWord;
            public Node [] children ;
            Node(){
                isWord =false;
                children = new Node[26];
            }
        }
        Node root;
        public Trie()
        {
           root = new Node();

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index =  word.charAt(i) - 'a';
                if(cur.children[index] == null){
                    cur.children[index] = new Node();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(cur.children[index] == null){return false;}
                cur = cur.children[index];
            }
            return cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if(cur.children[index] == null){return false;}
                cur = cur.children[index];
            }
            return true;
        }
    }
}
