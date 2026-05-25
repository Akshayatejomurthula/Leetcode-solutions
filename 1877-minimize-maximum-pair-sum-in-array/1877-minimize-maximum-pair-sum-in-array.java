import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        int n = nums.length;
        int maxPairSum = 0;
        
        // Step 2: Pair smallest with largest
        for (int i = 0; i < n / 2; i++) {
            int pairSum = nums[i] + nums[n - 1 - i];
            maxPairSum = Math.max(maxPairSum, pairSum);
        }
        
        // Step 3: Return minimized maximum pair sum
        return maxPairSum;
    }
}