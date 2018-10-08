public class Num394 {
    class Solution {
        /**
         * 思路：采用递归的思想，遇到'['就将内部的字符串作为子问题去求解
         * 当遇到']'时，子问题求解返回*/
        private String s;
        // 这里的pos作为全局变量，处理子问题时指针也需要移动，并且对指针的更改应该是永久的
        private int pos;
        public StringBuilder decoder(){
            StringBuilder word = new StringBuilder();
            // num用来记录[前面的数字
            int num = 0;
            while(pos < s.length()){
                char c = s.charAt(pos);
                pos++;
                if(c == '['){
                    // 如果为'['，就递归求出括号内部的字符
                    StringBuilder tmp = decoder();
                    // 将其重复num遍
                    for(int i = 0;i < num;i++){
                        word.append(tmp);
                    }
//                    num要重新归零
                    num = 0;
                } else if(c == ']'){
//                    出现']',则这个子过程的任务就完成了，返回处理得到的字符串
                    return word;
                } else if(c <= '9' && c >= '0'){
//                    如果是数字，则加到numz中
                    num = num*10 + c - '0';
                } else{
//                    如果是正常的字符，就直接加到要返回的结果中即可
                    word.append(c);
                }
            }
            return word;
        }
        public String decodeString(String s) {

            this.s = s;
            this.pos = 0;
            return decoder().toString();
        }
    }


}
