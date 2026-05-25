from typing import List
import heapq

class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        # Sort events by start time
        events.sort()
        
        max_val = 0        # Best single event value so far
        ans = 0
        
        # Min-heap based on end time: (end, value)
        pq = []
        
        for start, end, value in events:
            # Remove all events that end before current start
            while pq and pq[0][0] < start:
                _, v = heapq.heappop(pq)
                max_val = max(max_val, v)
            
            # Update answer using best previous + current
            ans = max(ans, max_val + value)
            
            # Push current event
            heapq.heappush(pq, (end, value))
        
        return ans