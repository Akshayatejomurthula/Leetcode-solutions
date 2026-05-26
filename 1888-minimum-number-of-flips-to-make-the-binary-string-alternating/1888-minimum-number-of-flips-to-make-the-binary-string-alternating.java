class Solution {

    public int minFlips(String s) {

        int n = s.length();

        // doubled string for rotations
        String str = s + s;

        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        // create alternating patterns
        for (int i = 0; i < 2 * n; i++) {

            if (i % 2 == 0) {
                alt1.append('0');
                alt2.append('1');
            } else {
                alt1.append('1');
                alt2.append('0');
            }
        }

        int diff1 = 0;
        int diff2 = 0;

        int left = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < 2 * n; right++) {

            if (str.charAt(right) != alt1.charAt(right))
                diff1++;

            if (str.charAt(right) != alt2.charAt(right))
                diff2++;

            // maintain window size n
            if (right - left + 1 > n) {

                if (str.charAt(left) != alt1.charAt(left))
                    diff1--;

                if (str.charAt(left) != alt2.charAt(left))
                    diff2--;

                left++;
            }

            // valid rotation
            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}