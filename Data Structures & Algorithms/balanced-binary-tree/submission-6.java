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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+ Math.max(maxDepth(root.right), maxDepth(root.left));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        return Math.abs(leftH - rightH) < 2 && isBalanced(root.right) && isBalanced(root.left);
    }
}
