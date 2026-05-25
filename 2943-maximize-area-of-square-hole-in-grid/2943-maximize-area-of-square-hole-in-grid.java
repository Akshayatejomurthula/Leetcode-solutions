import java.util.*;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = longestConsecutive(hBars) + 1;
        int maxV = longestConsecutive(vBars) + 1;

        int side = Math.min(maxH, maxV);
        return side * side;
    }

    private int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        int max = 1, curr = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                curr++;
                max = Math.max(max, curr);
            } else {
                curr = 1;
            }
        }
        return max;
    }
}