class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sz = len(nums)
        if sz ==0:
            return 0
        elif sz == 1:
            return nums[0]
        elif sz == 2:
            return max(nums)
        elif sz == 3:
            return max(nums[0]+nums[2],nums[1])
        else:
            dp = [nums[0],nums[1],nums[0]+nums[2]]
            
            for i in range(3,sz):
                t = max(dp[i-2]+nums[i],dp[i-3]+nums[i])
                dp.append(t)
        return max(dp)