class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums)
        if size == 0:
            return 0
        max = 0
        dp = list(range(size+1))
        for i,val in enumerate(nums):
            if(dp[i] > 0):
                dp[i+1]=dp[i]+val
            else:
                dp[i+1] = val
            if dp[i+1]>max:
                max = dp[i+1]
        return max
if __name__=='__main__':
    s = Solution()
    nums = [-2,1,-3,4,-1,2,1,-5,4]
    print(s.maxSubArray(nums))