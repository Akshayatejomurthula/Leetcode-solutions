class Solution:
    def minimumCost(self, source, target, original, changed, cost):

        INF = float('inf')

        # 26 x 26 distance matrix
        dist = [[INF] * 26 for _ in range(26)]

        # Distance to itself = 0
        for i in range(26):
            dist[i][i] = 0

        # Fill direct transformation costs
        for o, c, w in zip(original, changed, cost):

            u = ord(o) - ord('a')
            v = ord(c) - ord('a')

            dist[u][v] = min(dist[u][v], w)

        # Floyd-Warshall
        for k in range(26):
            for i in range(26):
                for j in range(26):

                    if dist[i][k] != INF and dist[k][j] != INF:
                        dist[i][j] = min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        )

        # Compute answer
        total = 0

        for s, t in zip(source, target):

            if s == t:
                continue

            u = ord(s) - ord('a')
            v = ord(t) - ord('a')

            if dist[u][v] == INF:
                return -1

            total += dist[u][v]

        return total