class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        '''
           
        '''
        left = {'(','{','['}
        brackets = {')':'(',']':'[','}':'{'}
        l = []
        sz = 0
        for c in s:
            if c in left:
                l.append(c)
                sz = sz + 1
            elif sz == 0:
                return False
            elif l.pop()!=brackets[c]:
                return False
            else:
                sz = sz - 1
        if sz==0:
            return True
        return False
if __name__ == '__main__':
    s = Solution()
    str='([)]'
    print(s.isValid(str))