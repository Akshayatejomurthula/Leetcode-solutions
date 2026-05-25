class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0) return false;   // no increasing part

        int j = i;
        while (j + 1 < n && nums[j] > nums[j + 1]) {
            j++;
        }
        if (j == i) return false;   // no decreasing part

        int k = j;
        while (k + 1 < n && nums[k] < nums[k + 1]) {
            k++;
        }
        if (k == j) return false;   // no final increasing part

        // must consume the whole array
        return k == n - 1;
    }
}