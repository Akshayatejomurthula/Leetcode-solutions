class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);

            // Even numbers are impossible
            if ((p & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            // Count trailing ones
            int temp = p;
            int trailingOnes = 0;
            while ((temp & 1) == 1) {
                trailingOnes++;
                temp >>= 1;
            }

            // Minimum valid answer
            ans[i] = p - (1 << (trailingOnes - 1));
        }
        return ans;
    }
}