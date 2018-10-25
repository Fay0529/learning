# -*- coding: utf-8 -*-
"""
Created on Thu Oct 25 20:45:22 2018

@author: Fay
"""

class Solution(object):
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        if t == None:
            return True
        elif s == None:
            return False
        elif self.isSameTree(s,t):
            return True
        else:
            return self.isSubtree(s.left,t) or self.isSubtree(s.right,t)
    def isSameTree(self,s,t):
        if s == None and t == None:
            return True
        elif s != None and t != None and s.val == t.val:
            return self.isSameTree(s.left,t.left) and self.isSameTree(s.right,t.right)
        else :
            return False