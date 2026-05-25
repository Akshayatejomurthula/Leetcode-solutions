class Solution:
    def minDeletionSize(self, strs):
        rows = len(strs)
        cols = len(strs[0])
        delete_count = 0

        # Check each column
        for col in range(cols):
            for row in range(1, rows):
                # If current character is smaller than previous row
                if strs[row][col] < strs[row - 1][col]:
                    delete_count += 1
                    break

        return delete_count