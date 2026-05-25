class Solution {

    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] dp = new double[101][101];

        dp[0][0] = poured;

        for (int row = 0; row < 100; row++) {

            for (int glass = 0; glass <= row; glass++) {

                // extra champagne overflowing
                double extra = (dp[row][glass] - 1.0) / 2.0;

                if (extra > 0) {
                    dp[row + 1][glass] += extra;
                    dp[row + 1][glass + 1] += extra;
                }
            }
        }

        return Math.min(1.0, dp[query_row][query_glass]);
    }
}