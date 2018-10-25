class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = 1
        major = nums[0]
        l = len(nums)
        for i in range(1,l):
            if nums[i] != major:
                count = count - 1
                if count < 0:
                    count = 1
                    major = nums[i]
            else :
                count = count + 1
        return major