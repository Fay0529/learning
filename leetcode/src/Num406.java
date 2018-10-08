import java.util.Arrays;
import java.util.Comparator;

public class Num406 {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            /**
             * 思路：先对people按身高降序、count升序进行排序，然后对剩下的数据进行插入排序
             * 对于当前的元素people[i],身高大于等于他的人都在他前面，而他前面有people[i][1]个人身高大于等于他，只需将其往前挪到下标为i的地方
             * 将其往前挪的过程中，不会破坏被挪到后面数据的正确性*/
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]!=o2[0]){
                        return o2[0] - o1[0];
                    } else{
                        return o1[1] - o2[1];
                    }
                }
            });
            for(int i = 1; i < people.length; i++){
                int j  = i;
                int height = people[i][0];
                int count = people[i][1];
                while(j > count){
                    people[j][0] = people[j-1][0];
                    people[j][1] = people[j-1][1];
                    j--;
                }
                people[j][0] = height;
                people[j][1] = count;
            }
            return people;
        }
    }
}
