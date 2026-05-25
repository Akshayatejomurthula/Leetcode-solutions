class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // Prefix sum matrix
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n);

        while (low < high) {
            int mid = low + (high - low + 1) / 2;

            if (isValid(prefix, mid, threshold, m, n)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean isValid(int[][] prefix, int size, int threshold, int m, int n) {
        for (int i = size; i <= m; i++) {
            for (int j = size; j <= n; j++) {
                int sum = prefix[i][j]
                        - prefix[i - size][j]
                        - prefix[i][j - size]
                        + prefix[i - size][j - size];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}