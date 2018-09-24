import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Num49 {
    class Solution {

        /**
         * 思路：这题就是要将含有相同字母组合的字符串放到同一个list中
         * 首先对于每个字符串给它们排个序，统计排序后有多少中字符串
         * 然后再将原字符串放到对应组的list中
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            List<String> listForCount = new LinkedList<>();
            // mark[]用来记录每个字符串属于哪个组
            int []mark = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                char [] tmp =  strs[i].toCharArray();
                Arrays.sort(tmp);
                String strTmp = String.valueOf(tmp);
                if(listForCount.contains(strTmp)){
                    mark[i] = listForCount.indexOf(strTmp);
                    continue;
                }
                listForCount.add(strTmp);
                mark[i] = listForCount.indexOf(strTmp);
            }
            // 一共有n种
            int n = listForCount.size();
            List<List<String>> res = new LinkedList<>();
            for (int i = 0; i < n; i++){
                List<String> tmp = new LinkedList<>();
                for (int j = 0; j < strs.length; j++){
                    if (mark[j] == i){
                        tmp.add(strs[j]);
                    }
                }
                res.add(tmp);
            }
            return res;
        }
    }
    public static void main(String []args) {
        Num49 n = new Num49();
        Num49.Solution s = n.new Solution();
        String []strs={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res= s.groupAnagrams(strs);
        System.out.println(res.toString());
        return ;
    }
}
