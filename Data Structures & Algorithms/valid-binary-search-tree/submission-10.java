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
        return isValidBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBSTRec(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val <= min) return false;
        if (root.val >= max) return false;
        return isValidBSTRec(root.left, min, root.val) && isValidBSTRec(root.right, root.val, max);
    }
}
