class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;

        int cols = matrix[0].length;
        int[] height = new int[cols];
        int maxArea = 0;

        for (char[] row : matrix) {

            // Build histogram heights
            for (int i = 0; i < cols; i++) {
                if (row[i] == '1')
                    height[i]++;
                else
                    height[i] = 0;
            }

            // Find max rectangle for current histogram
            maxArea = Math.max(maxArea, largestRectangle(height));
        }
        return maxArea;
    }

    private int largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= h.length; i++) {
            int curr = (i == h.length) ? 0 : h[i];

            while (!stack.isEmpty() && curr < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}