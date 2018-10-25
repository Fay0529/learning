class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        lenA = 0
        lenB = 0
        pA = headA
        pB = headB
        while pA != None:
            lenA = lenA + 1
            pA = pA.next
        while pB != None:
            lenB = lenB + 1
            pB = pB.next
        if lenA == 0 or lenB == 0:
            return None
        if lenA > lenB:
            for i in range(0,lenA-lenB):
                headA = headA.next
        elif lenA < lenB:
            for i in range(0,lenB - lenA):
                headB = headB.next
        while headA!=None:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        return None