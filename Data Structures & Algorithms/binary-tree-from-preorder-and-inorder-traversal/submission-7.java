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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length)
            return null;
        int rootVal = preorder[0];
        int idx = 0;
        while (idx < inorder.length && inorder[idx] != rootVal) {
            idx++;
        }
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = buildTree(
            Arrays.copyOfRange(preorder, 1, idx + 1), Arrays.copyOfRange(inorder, 0, idx));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder, idx + 1, preorder.length),
            Arrays.copyOfRange(inorder, idx + 1, inorder.length));
        return treeNode;
    }
}