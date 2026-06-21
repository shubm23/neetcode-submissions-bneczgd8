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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer minValue, Integer maxValue) {
        if (node == null)
            return true;
        if (minValue != null && minValue <= node.val)
            return false;
        if (maxValue != null && maxValue >= node.val)
            return false;
        return isValidBST(node.left, node.val, maxValue)
            && isValidBST(node.right, minValue, node.val);
    }
}
