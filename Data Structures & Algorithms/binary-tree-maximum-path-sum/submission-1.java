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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{root.val};
        maxPathSumDfs(root, res);
        return res[0];
    }

    public int maxPathSumDfs(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = maxPathSumDfs(root.left, res);
        int right = maxPathSumDfs(root.right, res);
        int leftMax = Math.max(left, 0);
        int rMax = Math.max(right, 0);

        res[0] = Math.max(leftMax + rMax + root.val, res[0]);

        return root.val + Math.max(leftMax, rMax);
    }
}
