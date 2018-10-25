class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 1:
            return 1
        dp = list(range(n+1))
        for i,v in enumerate(dp):
            if i < 3:
                continue
            dp[i] = dp[i-1]+dp[i-2]
        return dp[n]
if __name__=='__main__':
    s = Solution()
    print(s.climbStairs(3))