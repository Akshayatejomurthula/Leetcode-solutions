from collections import deque

class Solution:
    def maxLevelSum(self, root):
        if not root:
            return 0

        q = deque([root])
        level = 1
        max_sum = float('-inf')
        answer = 1

        while q:
            size = len(q)
            level_sum = 0

            for _ in range(size):
                node = q.popleft()
                level_sum += node.val

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

            if level_sum > max_sum:
                max_sum = level_sum
                answer = level

            level += 1

        return answer