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
   * @return {number}
   */
  goodNodes(root) {
    let count = 0;
    (function dfs(root, maxValue) {
      if (!root) return;
      if (root?.val >= maxValue) {
        count++;
        maxValue = Math.max(maxValue, root?.val);
      }
      dfs(root?.left, maxValue);
      dfs(root?.right, maxValue);
    })(root, root ? root.val : 0);
    return count;
  }
}
