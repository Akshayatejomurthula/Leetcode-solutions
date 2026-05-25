class Solution:
    def separateSquares(self, param1):
        squares = param1  # Assumes param1 is the squares list
        
        if not squares:
            return 0.0
        
        total_area = sum(l * l for _, _, l in squares)
        target = total_area / 2.0
        
        max_top = max(y + l for _, y, l in squares)
        low, high = 0.0, max_top
        
        def area_below(h):
            area = 0.0
            for x, y, l in squares:
                if h <= y:
                    continue
                elif h >= y + l:
                    area += l * l
                else:
                    area += l * (h - y)
            return area
        
        for _ in range(100):
            mid = (low + high) / 2
            if area_below(mid) < target:
                low = mid
            else:
                high = mid
        
        return high
