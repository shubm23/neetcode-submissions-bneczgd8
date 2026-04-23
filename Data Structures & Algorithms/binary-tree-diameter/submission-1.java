/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = {0};
        diameterOfBinaryTreeDfs(root, res);
        return res[0];
    }

    private int diameterOfBinaryTreeDfs(TreeNode node, int[] res) {
        if (node == null) return 0;
        int left = diameterOfBinaryTreeDfs(node.left, res);
        int right = diameterOfBinaryTreeDfs(node.right, res);

        res[0] = Math.max(res[0], left + right);

        return 1 + Math.max(left, right);
    }
}
