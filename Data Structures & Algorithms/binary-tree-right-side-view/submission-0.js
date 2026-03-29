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
     * @return {number[]}
     */
    rightSideView(root) {
        const res = [];

    (function helper(root, level) {
      if (!root) return;
      if (level === res.length) {
        res.push(root?.val);
      }
      helper(root?.right, level + 1);
      helper(root?.left, level + 1);
    })(root, 0);

    return res;
    }
}
