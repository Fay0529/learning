class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left = 0
        right = len(nums)-1
        while left <= right:
            medium = (left+right)//2
            if nums[medium] == target:
                return medium
            elif nums[medium] < target:
                left = medium + 1
            else:
                right = medium - 1
        return left
if __name__ == '__main__':
    l = [1,3,5,6]
    s = Solution()
    print(s.searchInsert(l,2))