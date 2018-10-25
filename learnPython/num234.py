class Solution:
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head == None:
            return True
        slow = head
        fast = head        
        while fast.next != None and fast.next.next != None:
            fast = fast.next.next
            slow = slow.next
        fast = slow.next
        slow = self.reverseList(fast)
        while slow != None:
            if head.val != slow.val :
                return False
            head = head.next
            slow = slow.next
        return True
        
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