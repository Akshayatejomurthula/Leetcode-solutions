class Solution {
    long total = 0;
    long maxProduct = 0;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        totalSum(root);      // Step 1
        subtreeSum(root);    // Step 2
        return (int)(maxProduct % MOD);
    }

    // Find total sum of tree
    private void totalSum(TreeNode root) {
        if (root == null) return;
        total += root.val;
        totalSum(root.left);
        totalSum(root.right);
    }

    // Find subtree sums and max product
    private long subtreeSum(TreeNode root) {
        if (root == null) return 0;

        long left = subtreeSum(root.left);
        long right = subtreeSum(root.right);

        long sum = left + right + root.val;

        long product = sum * (total - sum);
        maxProduct = Math.max(maxProduct, product);

        return sum;
    }
}