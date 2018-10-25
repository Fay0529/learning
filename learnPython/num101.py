class Solution:
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return True
        queue = [root]
        while len(queue) != 0:
            n = len(queue)
            line = []
            while n >0 :
                n = n - 1
                node = queue.pop(0)
                if node != None:
                    line.append(node.val)
                    queue.append(node.left)
                    queue.append(node.right)
                else :
                    line.append(None)
            if line[::-1]!= line:
                return False
        return True