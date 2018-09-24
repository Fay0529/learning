import java.util.Stack;

public class Num20 {
    /**
     * 用栈来实现*/
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<>();
            if (s.length() % 2 != 0) return false;
            for (int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    st.push(s.charAt(i));
                }  else {
                    switch(s.charAt(i)){
                        case ')':
                            if (st.empty() || st.pop() != '(') {
                                return false;
                            }
                            break;
                        case ']':
                            if (st.empty() || st.pop() != '[') {
                                return false;
                            }
                            break;

                        default:
                            if (st.empty() || st.pop() != '{'){
                                return false;
                            }
                    }
                }
            }
            if (st.empty()){
                return true;
            }
            return false;
        }
    }
    public static void main(String []args){
        Num20 n = new Num20();
        Num20.Solution s = n.new Solution();
        System.out.println(s.isValid("(){}[]"));
    }
}
