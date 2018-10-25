package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Num207 {
    class Solution {
        /**
         * 拓扑排序：用数组inDegree[]记录每个点入度
         * 然后遍历inDegree，找到入度为零的点，将其压入队列
         * 然后当队列不为空时，从队列中取出第一个点，然后将其所有的出边删掉
         * 如果发现新的入度为0的点，就将其压入队列中。
         * 最后再遍历inDegree如果还存在入度不为零的点，那么就返回false
         * 否则返回true*/
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int [] inDegree = new int [numCourses];
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < prerequisites.length; i++){
                inDegree[prerequisites[i][1]]++;
            }
            for (int i = 0; i < inDegree.length; i++){
                if(inDegree[i] == 0){
                    queue.offer(i);
                }
            }
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int i = 0; i < prerequisites.length; i++){
                    if(prerequisites[i][0] == cur){
                        inDegree[prerequisites[i][1]] --;
                        if(inDegree[prerequisites[i][1]] == 0){
                            queue.offer(prerequisites[i][1]);
                        }
                    }
                }
            }
            for(int i = 0; i < inDegree.length; i ++) {
                if(inDegree[i] > 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
