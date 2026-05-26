class Solution {
    public int binaryGap(int n) {
        int last = -1;   // stores last position of 1
        int max = 0;     // stores maximum distance
        int index = 0;   // current bit position
        
        while (n > 0) {
            if (n % 2 == 1) {  // if current bit is 1
                if (last != -1) {
                    max = Math.max(max, index - last);
                }
                last = index;
            }
            n = n / 2;   // shift right
            index++;
        }
        
        return max;
    }
}