package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Num215 {
  /**
   * 可以用优先队列来实现
   * 建立一个k个元素的优先队列，将数组前k个元素放入队列，然后对于后面的每个元素
   * 将其与队列最小元素比较，如果比它大，那就将队列最小元素出队列，将次元素入队列
   * 最后返回队列最小的元素即为第k大的元素*/
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> queue =  new PriorityQueue<>(k);
            for(int i = 0; i < k; i++){
                queue.offer(nums[i]);
            }
            for(int i = k; i < nums.length; i++){
                int t = queue.peek();
                if(t < nums[i]){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
            return queue.poll();
        }
    }
}

