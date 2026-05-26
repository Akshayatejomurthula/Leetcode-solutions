class Solution:
    def survivedRobotsHealths(self, positions, healths, directions):
        n = len(positions)
        
        robots = sorted(
            [(positions[i], healths[i], directions[i], i) for i in range(n)]
        )
        
        stack = []  # will store indices in robots list
        alive = [True] * n
        curr_health = [h for h in healths]

        for pos, h, d, idx in robots:
            if d == 'R':
                stack.append(idx)
            else:  # d == 'L'
                while stack and curr_health[idx] > 0:
                    top = stack[-1]

                    if curr_health[top] == 0:
                        stack.pop()
                        continue

                    if curr_health[top] > curr_health[idx]:
                        curr_health[top] -= 1
                        curr_health[idx] = 0
                    elif curr_health[top] < curr_health[idx]:
                        curr_health[idx] -= 1
                        curr_health[top] = 0
                        stack.pop()
                    else:
                        curr_health[top] = 0
                        curr_health[idx] = 0
                        stack.pop()
                        break

        # collect survivors
        result = []
        for i in range(n):
            if curr_health[i] > 0:
                result.append(curr_health[i])

        return result