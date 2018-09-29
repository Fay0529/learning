import java.util.Stack;

public class Num155 {
    /**
     * 思路：这题的难点在于在常数时间内得到最小值
     * 必须采用某种方式使得弹出一个值后，如果这个值正好是最小值，最小值得更新为上次的最小值。
     * 所以我们可以发现，当一个值ｘ进入栈时，并且它更新了最小值，那么当它弹出栈时一定要把它更新前的最小值取出来
     * 所以可以将更新前的最小值在它之前先进栈，这样在出栈时就可以判断出栈的值是否为最小值，如果是则可以再出一次栈把上一次最小值拿出来*/
    class MinStack {
        int min;
        Stack<Integer> st;
        /** initialize your data structure here. */
        public MinStack() {
            min = Integer.MAX_VALUE;
            st = new Stack<Integer>();
        }

        public void push(int x) {
            if(x <= min){
                // 在更新min前，先压入栈中，然后再将要加入的值入栈
                st.push(min);
                min = x;

            }
            st.push(x);
        }

        public void pop() {
            if(st.pop() == min){
//                出栈时进行判断是否就是最小值
                min = st.pop();
            }
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return min;
        }
    }

}
