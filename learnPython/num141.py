class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        fast = head
        slow = head
        while fast != None and fast.next!= None:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                return True
        return False