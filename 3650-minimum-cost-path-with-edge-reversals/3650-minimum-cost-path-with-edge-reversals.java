import java.util.*;

class Solution {

    static class Edge {
        int to, w;
        Edge(int t, int w) {
            this.to = t;
            this.w = w;
        }
    }

    static class State implements Comparable<State> {
        long cost;
        int node;

        State(long c, int n) {
            cost = c;
            node = n;
        }

        public int compareTo(State other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    public int minCost(int n, int[][] edges) {

        List<Edge>[] out = new ArrayList[n]; // normal edges
        List<Edge>[] in  = new ArrayList[n]; // incoming edges (for reversal)

        for (int i = 0; i < n; i++) {
            out[i] = new ArrayList<>();
            in[i]  = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            out[u].add(new Edge(v, w));
            in[v].add(new Edge(u, w));
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.offer(new State(0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            long cost = cur.cost;
            int u = cur.node;

            if (cost > dist[u]) continue;

            // 1. Normal forward edges
            for (Edge e : out[u]) {
                int v = e.to;
                long newCost = cost + e.w;

                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.offer(new State(newCost, v));
                }
            }

            // 2. Reverse one incoming edge using u's switch
            for (Edge e : in[u]) {
                int v = e.to; // reversing v -> u into u -> v
                long newCost = cost + 2L * e.w;

                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.offer(new State(newCost, v));
                }
            }
        }

        return dist[n - 1] >= INF ? -1 : (int) dist[n - 1];
    }
}
