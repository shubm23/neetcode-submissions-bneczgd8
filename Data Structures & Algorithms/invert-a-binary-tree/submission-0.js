/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * @param {TreeNode} root
     * @return {TreeNode}
     */
    invertTree(root) {
        if(!root) return null;
        const leftNode = this.invertTree(root?.left);
        const rightNode = this.invertTree(root?.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
