# -*- coding: utf-8 -*-
"""
Created on Thu Oct 25 20:44:55 2018

@author: Fay
"""

class Solution(object):
    res = 0
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.helper(root)
        return self.res
    def helper(self,root):
        if root == None:
            return 0
        leftHeight = self.helper(root.left)
        rightHeight = self.helper(root.right)
        if leftHeight + rightHeight > self.res:
            self.res = leftHeight + rightHeight
            
        return max(leftHeight,rightHeight) + 1