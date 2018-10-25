# -*- coding: utf-8 -*-
"""
Created on Thu Oct 25 20:46:24 2018

@author: Fay
"""

class Solution:
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if t1==None and t2 == None:
            return None
        elif t1 == None:
            return t2
        elif t2 == None:
            return t1
        else:
            t1.val = t1.val + t2.val
            t1.left = self.mergeTrees(t1.left,t2.left)
            t1.right = self.mergeTrees(t1.right,t2.right)
        return t1