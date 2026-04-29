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
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeDfs(root);
        return res;
    }

    private int diameterOfBinaryTreeDfs(TreeNode node) {
        if (node == null) return 0;
        int left = diameterOfBinaryTreeDfs(node.left);
        int right = diameterOfBinaryTreeDfs(node.right);

        res = Math.max(res, left + right);

        return 1 + Math.max(left, right);
    }
}
