class Solution:
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        l = []
        sz = len(nums)
        if sz <= 1:
            return
        if nums[0] == 0:
            l.append(1)
        else:
            l.append(0)
        for i in range(1,sz):
            if nums[i] == 0:
                l.append(l[-1]+1)
            else :
                l.append(l[-1])
        for i in range(sz):
            if nums[i] != 0:
                nums[i-l[i]]=nums[i]
        for i in range(sz - l[-1],sz):
            nums[i] = 0