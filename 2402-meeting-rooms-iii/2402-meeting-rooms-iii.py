import heapq

class Solution:
    def mostBooked(self, n: int, meetings: list[list[int]]) -> int:
        meetings.sort()
        
        free_rooms = list(range(n))
        heapq.heapify(free_rooms)
        
        busy_rooms = []  # (end_time, room)
        count = [0] * n
        
        for start, end in meetings:
            duration = end - start
            
            # Free rooms that have finished
            while busy_rooms and busy_rooms[0][0] <= start:
                _, room = heapq.heappop(busy_rooms)
                heapq.heappush(free_rooms, room)
            
            if free_rooms:
                room = heapq.heappop(free_rooms)
                heapq.heappush(busy_rooms, (end, room))
            else:
                end_time, room = heapq.heappop(busy_rooms)
                new_end = end_time + duration
                heapq.heappush(busy_rooms, (new_end, room))
            
            count[room] += 1
        
        # Return room with maximum count (lowest index in case of tie)
        return count.index(max(count))