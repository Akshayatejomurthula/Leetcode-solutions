class Solution {

    public int concatenatedBinary(int n) {

        long mod = 1000000007;
        long result = 0;

        int bits = 0;

        for (int i = 1; i <= n; i++) {

            // if power of 2, increase bit length
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            result = ((result << bits) + i) % mod;
        }

        return (int) result;
    }
}