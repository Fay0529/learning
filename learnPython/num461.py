# -*- coding: utf-8 -*-
"""
Created on Thu Oct 25 20:44:07 2018

@author: Fay
"""

class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        z = x ^ y
        res = 0
        while z > 0:
            res = res + z % 2
            z = z // 2
        return res