from collections import deque

class Solution:
    def canReach(self, arr, start):
        n = len(arr)
        visited = set()
        
        queue = deque([start])
        visited.add(start)
        
        while queue:
            i = queue.popleft()
            
            # If value is 0, success
            if arr[i] == 0:
                return True
            
            # Possible next positions
            next_positions = [i + arr[i], i - arr[i]]
            
            for nxt in next_positions:
                if 0 <= nxt < n and nxt not in visited:
                    visited.add(nxt)
                    queue.append(nxt)
        
        return False