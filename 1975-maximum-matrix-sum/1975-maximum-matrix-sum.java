class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = matrix[i][j];

                if (val < 0) negativeCount++;

                sum += Math.abs(val);
                min = Math.min(min, Math.abs(val));
            }
        }
    
        if (negativeCount % 2 == 1) {
            sum -= 2 * min;
        }

        return sum;
    }
}