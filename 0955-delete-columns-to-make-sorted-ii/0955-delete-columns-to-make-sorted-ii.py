class Solution:
    def minDeletionSize(self, strs):
        n = len(strs)
        m = len(strs[0])

        deleted = 0

        # sorted_pairs[i] means strs[i] < strs[i+1] already confirmed
        sorted_pairs = [False] * (n - 1)

        for col in range(m):

            # Check if this column causes disorder
            bad = False

            for row in range(n - 1):
                if not sorted_pairs[row] and strs[row][col] > strs[row + 1][col]:
                    bad = True
                    break

            # If bad column -> delete it
            if bad:
                deleted += 1
                continue

            # Otherwise update confirmed sorted pairs
            for row in range(n - 1):
                if strs[row][col] < strs[row + 1][col]:
                    sorted_pairs[row] = True

        return deleted