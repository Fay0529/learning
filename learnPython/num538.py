# -*- coding: utf-8 -*-
"""
Created on Thu Oct 25 20:44:33 2018

@author: Fay
"""

class Solution(object):
    sum = 0
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root == None:
            return root
        self.convertBST(root.right)
        self.sum = self.sum + root.val
        root.val = self.sum
        self.convertBST(root.left)
        return root