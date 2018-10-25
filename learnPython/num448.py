# -*- coding: utf-8 -*-
"""
Created on Thu Oct 25 20:43:40 2018

@author: Fay
"""

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        N = len(nums) + 1
        i = 0
        while i < N-1:
            if nums[i] == N:
                i = i + 1
                continue
            if nums[nums[i]-1] != N:
                t = nums[i]
                nums[i] = nums[nums[i]-1]
                nums[t-1] = N
            else :
                i = i + 1
        res = []
        for i,v in enumerate(nums):
            if v != N:
                res.append(i+1)
        return res