class Solution {
    private int[][] dp;

    private int solve(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int pickLeft = nums[i] - solve(nums, i + 1, j);
        int pickRight = nums[j] - solve(nums, i, j - 1);

        dp[i][j] = Math.max(pickLeft, pickRight);
        return dp[i][j];
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return solve(nums, 0, n - 1) >= 0;
    }
}