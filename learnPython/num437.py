# -*- coding: utf-8 -*-
"""
Created on Wed Oct 24 23:15:47 2018

@author: Fay
"""

class Solution:
    # include用来记录父节点有没有在当前路径中
    include  = False
    count = 0
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        if root == None:
            return 0
        if sum - root.val == 0:
            self.count = self.count + 1
        if self.include:
            self.pathSum(root.left,sum - root.val)
            self.pathSum(root.right,sum - root.val)
        else :
            self.include = True
            self.pathSum(root.left,sum - root.val)
            self.pathSum(root.right,sum - root.val)
            self.include = False
            self.pathSum(root.left,sum)
            self.pathSum(root.right,sum)
        return self.count