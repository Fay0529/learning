class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        sz = len(prices)
        if sz <= 1:
            return 0
        imax = 0
        dp = list(range(sz))
        for i in range(1,sz):
            dp[i] = max(prices[i]-prices[i-1] + dp[i-1],prices[i]-prices[i-1])
            if dp[i] > imax:
                imax = dp[i]
        return imax
if __name__=='__main__':
    s = Solution()
    input = [7,1,5,3,6,4]
    print(s.maxProfit(input))
    input = [7,6,4,3,1]
    print(s.maxProfit(input))