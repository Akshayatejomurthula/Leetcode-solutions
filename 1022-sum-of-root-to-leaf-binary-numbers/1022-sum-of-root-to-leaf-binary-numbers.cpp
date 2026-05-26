class Solution {
public:

    int dfs(TreeNode* node, int current) {

        if (node == nullptr)
            return 0;

        // build binary number
        current = current * 2 + node->val;

        // leaf node
        if (node->left == nullptr && node->right == nullptr)
            return current;

        return dfs(node->left, current) +
               dfs(node->right, current);
    }

    int sumRootToLeaf(TreeNode* root) {

        return dfs(root, 0);
    }
};