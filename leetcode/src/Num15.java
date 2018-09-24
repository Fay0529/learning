import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    /**
     * 思路：O(n*n)算法，首先对给定序列进行排序，然后是双重循环
     * 第一层循环确定三个数中的第一个，第二重循环确定另外两个
     * 关键在于第二重循环，可通过遍历一次即可确定另外两个*/
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int i = 0,j,k;
            List<List<Integer>> res = new LinkedList<List<Integer>>();
            while(i < nums.length) {
                int target = -nums[i];
                // j 指向较小的数
                j = i + 1;
                // k 指向最大的数
                k = nums.length - 1;
                while (j < k) {
                    int sum = nums[j] + nums[k];
                    if (sum > target) {
                        // 如果剩余两个数的和大于第三个数的取反，
                        // 那么让k减小,可以使和减小
                        k--;
                    } else if(sum < target) {
                        // 如果剩余两个数的和小于第三个数的取反，
                        // 那么让j增大，可以使和增大
                        j++;
                    } else {
                        // 否则将解加入结果中
                        List<Integer> tmp = new LinkedList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        res.add(tmp);
                        // 去重
                        j ++;
                        k --;
                        while(j < k && nums[j-1] == nums[j]){
                            j++;
                        }
                        while(k > j && nums[k + 1] == nums[k]) {
                            k--;
                        }
                    }
                }
                // 去重
                i++;
                while (i < nums.length && nums[i] == nums[i-1]) {
                    i++;
                }
            }
            return res;
        }
    }
    public static void main(String []args) {
        ThreeSum threeSum = new ThreeSum();
        ThreeSum.Solution s = threeSum.new Solution();
        int []array = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> l = s.threeSum(array);
        for (List<Integer> list : l) {
            System.out.println(list);
        }
    }
}
