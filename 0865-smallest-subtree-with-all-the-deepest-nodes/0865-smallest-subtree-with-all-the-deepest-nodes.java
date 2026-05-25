class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Helper class to carry both the candidate node and its depth
    private static class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }

    // Returns: (smallest subtree root containing all deepest nodes in this subtree, max depth)
    private Pair dfs(TreeNode root) {
        if (root == null) {
            // depth 0 with no node
            return new Pair(null, 0);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if (left.depth > right.depth) {
            // deepest nodes only in left subtree
            return new Pair(left.node, left.depth + 1);
        } else if (right.depth > left.depth) {
            // deepest nodes only in right subtree
            return new Pair(right.node, right.depth + 1);
        } else {
            // equal depth on both sides: current root is LCA of all deepest nodes
            return new Pair(root, left.depth + 1);
        }
    }
}
