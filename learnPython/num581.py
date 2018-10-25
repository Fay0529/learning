# -*- coding: utf-8 -*-
"""
Created on Thu Oct 25 20:45:48 2018

@author: Fay
"""

class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
# =============================================================================
#         该子序列的特点是：子序列中的最右边元素一定小于该元素左边的最大元素
#         子序列中的最左边元素一定大于该元素右边的最小元素
# ============================================================================
        sz = len(nums)
        if sz < 2:
            return 0
        
        imax = nums[0] # 记录左边最大元素
        imin = nums[-1] # 记录右边最小元素
        end = 0
        begin = 1
        for i in range(1,sz):
            if imax <= nums[i]:
                imax = nums[i]
            else:
                # 最右边元素小于左边最大元素
                end = i
            if imin >= nums[ sz - i - 1]:
                imin = nums[ sz -i - 1]
            else:
                # 最左边元素大于右边最小元素
                begin = sz - i - 1
        return end - begin + 1