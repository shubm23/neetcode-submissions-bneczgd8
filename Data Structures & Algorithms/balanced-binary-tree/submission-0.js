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
     * @return {boolean}
     */
maxDepth(root) {
    if (!root) return 0;
    return 1 + Math.max(this.maxDepth(root?.left), this.maxDepth(root?.right));
  }

  isBalanced(root) {
    if(!root) return true;
    const rightHeightVal = this.maxDepth(root?.right);
    const leftHeightVal = this.maxDepth(root?.left);
    return (Math.abs(rightHeightVal-leftHeightVal) < 2) && this.isBalanced(root?.left) && this.isBalanced(root?.right);
  }

  }
