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
    private int count; // Tracker for k that persists across recursive calls

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        kthSmallestDfs(root);
        return res;
    }

    private void kthSmallestDfs(TreeNode node) {
        // Base case: stop if node is null or we already found our answer
        if (node == null || count == 0) {
            return;
        }
        
        // 1. Traverse Left
        kthSmallestDfs(node.left);
        
        // 2. Process Current Node
        count--;
        if (count == 0) {
            res = node.val;
            return; // Found it! Stop deeper exploration.
        }
        
        // 3. Traverse Right
        kthSmallestDfs(node.right);
    }
}