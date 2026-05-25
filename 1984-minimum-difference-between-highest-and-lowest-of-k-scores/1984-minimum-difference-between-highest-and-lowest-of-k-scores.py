class Solution:
    def minimumDifference(self, nums, k):

        # If only one student chosen
        if k == 1:
            return 0

        nums.sort()

        ans = float('inf')

        # Sliding window of size k
        for i in range(len(nums) - k + 1):

            diff = nums[i + k - 1] - nums[i]

            ans = min(ans, diff)

        return ans