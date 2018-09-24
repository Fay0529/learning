import java.util.*;

public class Num56 {
     public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }
    /**
     * 思路：首先对原来的数据进行排序，按照主start 次 end进行比较
     * 然后遍历数据，如果它和结果列表中的最后一个元素重合就合并，否则就加到结果列表中*/
    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() <= 1) {
                return intervals;
            }
            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if (o1.start != o2.start){
                        return o1.start < o2.start? -1:1;
                    } else if(o1.end != o2.end){
                        return o1.end < o2.end? -1 : 1;
                    } else{
                        return 0;
                    }
                }
            });
            List<Interval>res = new LinkedList<Interval>();
            res.add(intervals.get(0));
            for (int i =1; i < intervals.size(); i++) {
                Interval a = ((LinkedList<Interval>) res).getLast();
                Interval b = intervals.get(i);
                if(a.end >= b.start){
                    if(a.end < b.end){
                        a.end = b.end;
                    }
                } else {
                    res.add(b);
                }
            }
            return res;
        }
    }
}
