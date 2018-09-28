import java.util.List;

public class Num139 {
    /** 思路：采用动态规划法。令dp[i]表示前i个字符有没有被匹配成功
     * 则dp[i] = dp[i - word.length] == true? (substring(i-word.length,i).equals(word)?true:false):false*/
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean []dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i < dp.length; i++){
                for(String word : wordDict){
                    if(i >= word.length()) {
                        dp[i] = dp[i - word.length()] == true ? (s.substring(i - word.length(), i).equals(word) ? true : false) : false;
                        if(dp[i] == true){
                            break;
                        }
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
