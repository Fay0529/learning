package leetcode;

import java.util.Arrays;

public class Num621 {
    class Solution {

        int[] count = new int[26];
        /**
         * 思路：有两种情形，一种某个周期（n+1)个interval中有idle状态的，一种所有周期安排的满满的没有idle状态的
         * 后者结果就是任务的数量
         * 如果是前者，它的结果一定不会小于后者的结果。如果计算出来的结果比后者还小，那么说明那样安排是不合理的
         * 如果只能按照前者去安排，就可以用一下公式去算：设出现频率最大的任务的频率为k,而最大频率的任务数量为s
         * 那么总的时间为 (k-1)*(n+1)+s .意思就是前k-1个周期中，每个周期都安排最大频率的某个任务，其它频率最大的任务均匀插到空里
         * 剩下的频率小的也插到空里。这样在k-1个周期内会将频率低的全部安排完，还剩下s个任务至少需要s个时间
         * 会不会出现频率小的但是在前k-1个周期还没安排完呢？答案是不会的，这样就会安排的满满的，就会成为第二种情况，这时候公式算出来的结果会比任务的数量还要小
         * */
        public int leastInterval(char[] tasks, int n) {
            int res = 0;
            if (n == 0) {
                return tasks.length;
            }
            for (char c : tasks) {
                count[c - 'A']++;
            }
            Arrays.sort(count);
            int i = 25;
            while (i > 0) {
                if (count[i] != count[25]) {
                    break;
                }
                i--;
            }
            return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);

        }
    }
}
