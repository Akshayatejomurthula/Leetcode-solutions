class Solution {
    public int[] plusOne(int[] digits) {
        // Traverse from the last digit backwards
        for (int i = digits.length - 1; i >= 0; i--) {
            // Add 1 to the current digit
            digits[i]++;
            
            // If digit < 10, no carry → return result
            if (digits[i] < 10) {
                return digits;
            }
            
            // Otherwise, set current digit to 0 and continue loop (carry over)
            digits[i] = 0;
        }
        
        // If we reach here, all digits were 9 (e.g., 999 → 1000)
        int[] result = new int[digits.length + 1];
        result[0] = 1;  // Leading 1
        return result;
    }
}