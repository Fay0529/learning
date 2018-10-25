class Solution:
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root == None:
            return root
        tmp = root.left
        root.left =root.right
        root.right = tmp
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root