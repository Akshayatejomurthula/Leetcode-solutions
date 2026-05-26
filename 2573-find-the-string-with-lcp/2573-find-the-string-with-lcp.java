import java.util.*;

class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        
        // Step 1: Basic validation
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
        }
        
        // Union-Find
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        // Find
        java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
            public int applyAsInt(int x) {
                if (parent[x] != x) parent[x] = applyAsInt(parent[x]);
                return parent[x];
            }
        };
        
        // Union
        java.util.function.BiConsumer<Integer, Integer> union = (a, b) -> {
            int pa = find.applyAsInt(a);
            int pb = find.applyAsInt(b);
            if (pa != pb) parent[pb] = pa;
        };
        
        // Step 2: Merge equal positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union.accept(i, j);
                }
            }
        }
        
        // Step 3: Assign characters
        char[] res = new char[n];
        Map<Integer, Character> map = new HashMap<>();
        char ch = 'a';
        
        for (int i = 0; i < n; i++) {
            int p = find.applyAsInt(i);
            if (!map.containsKey(p)) {
                if (ch > 'z') return "";
                map.put(p, ch++);
            }
            res[i] = map.get(p);
        }
        
        // Step 4: Validate LCP
        int[][] dp = new int[n+1][n+1];
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (res[i] == res[j]) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = 0;
                }
                
                if (dp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }
        
        return new String(res);
    }
}