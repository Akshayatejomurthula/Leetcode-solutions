import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007L;

        // Step 1: add boundary fences
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[h.length - 1] = m;
        for (int i = 0; i < hFences.length; i++) {
            h[i + 1] = hFences[i];
        }

        v[0] = 1;
        v[v.length - 1] = n;
        for (int i = 0; i < vFences.length; i++) {
            v[i + 1] = vFences[i];
        }

        Arrays.sort(h);
        Arrays.sort(v);

        // Step 2: store all vertical distances
        Set<Integer> verticalDistances = new HashSet<>();
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                verticalDistances.add(v[j] - v[i]);
            }
        }

        // Step 3: check horizontal distances and find max common
        long maxSide = 0;
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                int dist = h[j] - h[i];
                if (verticalDistances.contains(dist)) {
                    maxSide = Math.max(maxSide, dist);
                }
            }
        }

        // Step 4: result
        if (maxSide == 0) return -1;
        return (int) ((maxSide * maxSide) % MOD);
    }
}