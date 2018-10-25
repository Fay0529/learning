package leetcode;

import java.util.*;

public class Num347 {
    class Solution {
        class Node{
            int val;
            int cnt;
            Node(int x){
                val = x;
                cnt = 0;
            }
        }
        public List<Integer> topKFrequent(int[] nums, int k) {
            /**思路：首先将元素进行排序，复杂度是O(nlogn)
             * 然后自定义一个类，存储元素和它出现的次数，
             * 遍历一遍数组，将每个元素和它出现的次数放入一个优先级队列中
             * 最后pop出优先级队列中的前K个元素*/
            List<Integer>res = new LinkedList<>();
            if(nums.length == 1){
                res.add(nums[0]);
                return res;
            }
            Arrays.sort(nums);
            PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.cnt == o2.cnt){
                        return 0;
                    } else if(o1.cnt > o2.cnt){
                        return -1;
                    } else{
                        return 1;
                    }
                }
            });
            Node tmp = null ;
            for(int i = 0; i < nums.length; i++){
                if(i == 0){
                    tmp = new Node(nums[i]);
                    tmp.cnt++;
                } else{
                    if(nums[i] == nums[i - 1]){
                        // 如果这个数和上一个数相同，则直接将其计数值加1
                        tmp.cnt++;
                        if(i == nums.length - 1){q.offer(tmp);}
                    } else{
                        // 否则，先将原来的node存入优先级队列中，再创建一个新的node
                        q.offer(tmp);
                        tmp = new Node(nums[i]);
                        tmp.cnt++;
                    }
                }
            }

            for(int i = 0; i < k; i++){
                res.add(q.poll().val);
            }
            return res;
        }
    }
}
