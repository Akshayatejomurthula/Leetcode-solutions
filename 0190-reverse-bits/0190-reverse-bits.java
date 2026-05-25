class Solution {
    // Reverse bits of a 32-bit unsigned integer
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the last bit of n
            int bit = n & 1;
            
            // Shift result left and add the extracted bit
            result = (result << 1) | bit;
            
            // Shift n right to process the next bit
            n >>= 1;
        }
        return result;
    }
}