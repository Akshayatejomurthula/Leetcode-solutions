class Solution:
    def latestDayToCross(self, row: int, col: int, cells: list[list[int]]) -> int:
        n = row * col
        TOP = n
        BOTTOM = n + 1

        parent = list(range(n + 2))
        rank = [0] * (n + 2)

        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def union(x, y):
            rx, ry = find(x), find(y)
            if rx != ry:
                if rank[rx] < rank[ry]:
                    parent[rx] = ry
                elif rank[rx] > rank[ry]:
                    parent[ry] = rx
                else:
                    parent[ry] = rx
                    rank[rx] += 1

        grid = [[0] * col for _ in range(row)]

        directions = [(1,0), (-1,0), (0,1), (0,-1)]

        # Traverse days in reverse
        for day in range(len(cells) - 1, -1, -1):
            r, c = cells[day]
            r -= 1
            c -= 1
            grid[r][c] = 1
            idx = r * col + c

            # Connect with neighbors
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < row and 0 <= nc < col and grid[nr][nc] == 1:
                    union(idx, nr * col + nc)

            # Connect to virtual nodes
            if r == 0:
                union(idx, TOP)
            if r == row - 1:
                union(idx, BOTTOM)

            # Check connectivity
            if find(TOP) == find(BOTTOM):
                return day

        return 0
