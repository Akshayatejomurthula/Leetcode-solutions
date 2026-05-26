class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // Traverse from last bit to second bit
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if (bit == 1) {
                // odd -> add 1
                steps += 2;   // one for +1 and one for /2
                carry = 1;
            } else {
                // even -> divide by 2
                steps += 1;
            }
        }

        // If carry remains, add one more step
        return steps + carry;
    }
}