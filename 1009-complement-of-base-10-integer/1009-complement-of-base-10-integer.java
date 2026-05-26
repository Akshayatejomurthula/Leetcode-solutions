class Solution {

    public int bitwiseComplement(int n) {

        // special case
        if (n == 0) {
            return 1;
        }

        int mask = 0;
        int temp = n;

        // create mask of all 1s
        while (temp > 0) {

            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return n ^ mask;
    }
}