from collections import defaultdict
from functools import lru_cache
from typing import List

class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        # Build mapping: pair -> list of tops
        mp = defaultdict(list)
        for s in allowed:
            mp[s[:2]].append(s[2])

        @lru_cache(None)
        def dfs(row: str) -> bool:
            # If we reached the top
            if len(row) == 1:
                return True

            # Try to build next row
            def build_next(i, path):
                if i == len(row) - 1:
                    yield "".join(path)
                    return

                pair = row[i:i+2]
                if pair not in mp:
                    return

                for ch in mp[pair]:
                    path.append(ch)
                    yield from build_next(i + 1, path)
                    path.pop()

            # Try all possible next rows
            for nxt in build_next(0, []):
                if dfs(nxt):
                    return True

            return False

        return dfs(bottom)