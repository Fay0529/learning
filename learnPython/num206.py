class Solution:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        p0 = None
        p1 = head
        while p1 is not None:
            p2 = p1.next
            p1.next = p0
            p0 = p1
            p1 = p2
        return p0