package leetcode;

public class Num79 {
    class Solution {
        /**
         * 这个题目类似走迷宫类的题目，可以使用深度优先遍历的思想找到解
         * 首先尝试找到起点，并以当前起点进行遍历。
         * 然后定义个go[4][2]数组，用来定义相邻的四个方向
         * 然后定义mark[][]数组用来标记当前这个位置有没有走过
         * 对于四个方向合法的位置，可以尝试走下去
         * 递归的出口是当前数组的长度等于给定字符串的长度
         * 如果没有找到则寻找下一个起点继续找，直到所有起点都被尝试过还没找到，说明确实没有。*/
        // go数组用来记录四个方向
        int [][]go = {{0,1},{0,-1},{-1,0},{1,0}};
        boolean [][]mark ;
        private char[][] board;
        private String word;

        boolean dfs(int x, int y,int d){
            if(d == word.length() - 1 ){
                if(board[x][y] == word.charAt(d)){
                    return true;
                } else{
                    return false;
                }

            }
            if (board[x][y] == word.charAt(d)){
                mark[x][y] = true;
                for(int i = 0; i < 4; i++){
                    int goX = x + go[i][0];
                    int goY = y + go[i][1];
                    if(goX >= 0 && goX < board.length && goY >=0 && goY < board[0].length && mark[goX][goY] == false){
                        if(dfs(goX,goY,d+1)){
                            return true;
                        }
                        mark[goX][goY] = false;
                    }
                }
                return false;
            } else{
                return false;
            }


        }
        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.word = word;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == word.charAt(0)){
                        mark = new boolean[board.length][board[0].length];
                        if(dfs(i,j,0)){
                            return true;
                        }
                    }

                }
            }
            return false;
        }
    }
}
