class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        '''
        如何和java一样采用O(n^2)去实现会超时，所以采用hash方式存储出现过的数据
        '''
        m = {}
        for i,v in enumerate(nums):
            if target-v in m:
                return [m[target-v],i]
            m[v] = i
        return -1